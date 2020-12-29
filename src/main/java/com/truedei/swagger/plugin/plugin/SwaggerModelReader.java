package com.truedei.swagger.plugin.plugin;

import com.fasterxml.classmate.TypeResolver;
import com.truedei.swagger.plugin.annotation.Apicp;
import com.truedei.swagger.plugin.annotation.ApiIgp;
import com.google.common.base.Optional;
import io.swagger.annotations.ApiModelProperty;
import javassist.*;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ConstPool;
import javassist.bytecode.annotation.Annotation;
import javassist.bytecode.annotation.StringMemberValue;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ResolvedMethodParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.ParameterBuilderPlugin;
import springfox.documentation.spi.service.contexts.ParameterContext;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 针对传值的参数自定义注解
 * @author zhenghui
 * @date 2020年9月13日13:25:18
 * @desc 读取自定义的属性并动态生成model
 */
@Configuration
@Order(-19999)   //plugin加载顺序，默认是最后加载
public class SwaggerModelReader implements ParameterBuilderPlugin {

    @Autowired
    private TypeResolver typeResolver;

    static final Map<String,String> MAPS = new HashMap<>();
    static {
        MAPS.put("byte","java.lang.Byte");
        MAPS.put("short","java.lang.Short");
        MAPS.put("integer","java.lang.Integer");
        MAPS.put("long","java.lang.Long");
        MAPS.put("float","java.lang.Float");
        MAPS.put("double","java.lang.Double");
        MAPS.put("char","java.lang.Character");
        MAPS.put("string","java.lang.String");
        MAPS.put("boolean","java.lang.Boolean");
    }

    //根据用户自定义的类型拿到该类型所在的包的class位置
    static public String getTypePath(String key){
        return key==null || !MAPS.containsKey(key.toLowerCase()) ? null :  MAPS.get(key.toLowerCase());
    }



    Class newClass = null;

    @Override
    public void apply(ParameterContext context) {

        ResolvedMethodParameter methodParameter = context.resolvedMethodParameter();

         //自定义的注解
        Optional<ApiIgp>  apiIgp = methodParameter.findAnnotation(ApiIgp.class);
        Optional<Apicp>  apicp = methodParameter.findAnnotation(Apicp.class);


        //是否使用了两个注解其中的一个
        if (apiIgp.isPresent() || apicp.isPresent()) {
            Class originClass = null;//存放原始对象的class = classPath
            String[] properties = null; //注解传递的参数
            Integer annoType = 0;//注解的类型
            String name = null + "Model" + 1;  //model 名称  //参数名称
            String[] noValues = null;//新增参数的名称
            String[] noValueTypes = null;//新增参数的类型
            String[] noVlaueExplains = null;//新增参数的描述

            //拿到自定义注解传递的参数
            if (apiIgp.isPresent()){
                properties = apiIgp.get().values(); //排除的
                originClass = apiIgp.get().classPath();//原始对象的class
                name = apiIgp.get().modelName() ;  //model 名称  //参数名称

                noValues = apiIgp.get().noValues();
                noValueTypes = apiIgp.get().noValueTypes();
                noVlaueExplains = apiIgp.get().noVlaueExplains();

            }else {
                properties = apicp.get().values(); //需要的
                annoType = 1;
                originClass = apicp.get().classPath();//原始对象的class
                name = apicp.get().modelName() ;//自定义类的名字
                noValues = apicp.get().noValues();
                noValueTypes = apicp.get().noValueTypes();
                noVlaueExplains = apicp.get().noVlaueExplains();
            }

            //生成一个新的类
            newClass = createRefModelIgp(properties, noValues, noValueTypes, noVlaueExplains, name, originClass, annoType);


            context.getDocumentationContext()
                    .getAdditionalModels()
                    .add(typeResolver.resolve(newClass));  //向documentContext的Models中添加我们新生成的Class


            context.parameterBuilder()  //修改model参数的ModelRef为我们动态生成的class
                    .parameterType("body")
                    .modelRef(new ModelRef(name))
                    .name(name);

        }

    }

    /**
     *
     * @param properties annoType=1:需要的  annoType=0:排除的
     * @param noValues
     * @param noValueTypes
     * @param noVlaueExplains
     * @param name 创建的mode的名称
     * @param origin
     * @param annoType 注解的类型
     * @return
     */
    private Class createRefModelIgp(String[] properties, String[] noValues, String[] noValueTypes, String[] noVlaueExplains, String name, Class origin, Integer annoType) {
        try {
            //获取原始实体类中所有的变量
            Field[] fields = origin.getDeclaredFields();
            //转换成List集合，方便使用stream流过滤
            List<Field> fieldList = Arrays.asList(fields);
            //把传入的参数也转换成List
            List<String> dealProperties = Arrays.asList(properties);//去掉空格并用逗号分割
            //过滤出来已经存在的
            List<Field> dealFileds = fieldList
                    .stream()
                    .filter(s ->
                            annoType==0 ? (!(dealProperties.contains(s.getName()))) //如果注解的类型是0，说明要取反
                                        : dealProperties.contains(s.getName())
                            ).collect(Collectors.toList());

            //存储不存在的变量
            List<String> noDealFileds = Arrays.asList(noValues);
            List<String> noDealFiledTypes = Arrays.asList(noValueTypes);
            List<String> noDealFiledExplains = Arrays.asList(noVlaueExplains);


            //创建一个类
            ClassPool pool = ClassPool.getDefault();
            CtClass ctClass = pool.makeClass(origin.getPackage().getName()+"."+name);

            //创建对象，并把已有的变量添加进去
            createCtFileds(dealFileds,noDealFileds,noDealFiledTypes,noDealFiledExplains,ctClass,annoType);

            //返回最终的class
            return ctClass.toClass();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public boolean supports(DocumentationType delimiter) {
        return true;
    }

    /**
     * 根据propertys中的值动态生成含有Swagger注解的javaBeen
     *
     * @param dealFileds  原始对象中已经存在的对象属性名字
     * @param noDealFileds  原始对象中不存在的对象属性名字
     * @param noDealFiledTypes 原始对象中不存在的对象属性的类型，八大基本类型例如：dounle等，还有String
     * @param noDealFiledExplains  自定义变量的参数说明
     * @param ctClass 源class
     * @throws CannotCompileException
     * @throws NotFoundException
     * @throws ClassNotFoundException
     */
    public void createCtFileds(List<Field> dealFileds, List<String> noDealFileds, List<String> noDealFiledTypes,List<String> noDealFiledExplains, CtClass ctClass, Integer annoType) {
       //添加原实体类存在的的变量
        for (Field field : dealFileds) {
            CtField ctField = null;
            try {
                ctField = new CtField(ClassPool.getDefault().get(field.getType().getName()), field.getName(), ctClass);
            } catch (CannotCompileException e) {
                System.out.println("找不到了1："+e.getMessage());
            } catch (NotFoundException e) {
                System.out.println("找不到了2："+e.getMessage());
            }
            ctField.setModifiers(Modifier.PUBLIC);
            ApiModelProperty annotation = field.getAnnotation(ApiModelProperty.class);
            String apiModelPropertyValue = java.util.Optional.ofNullable(annotation).map(s -> s.value()).orElse("");



            if (StringUtils.isNotBlank(apiModelPropertyValue)) { //添加model属性说明
                ConstPool constPool = ctClass.getClassFile().getConstPool();

                AnnotationsAttribute attr = new AnnotationsAttribute(constPool, AnnotationsAttribute.visibleTag);
                Annotation ann = new Annotation(ApiModelProperty.class.getName(), constPool);
                ann.addMemberValue("value", new StringMemberValue(apiModelPropertyValue,constPool));
                attr.addAnnotation(ann);

                ctField.getFieldInfo().addAttribute(attr);
            }
            try {
                ctClass.addField(ctField);
            } catch (CannotCompileException e) {
                System.out.println("无法添加字段1："+e.getMessage());
            }
        }

        //添加原实体类中不存在的的变量
         for (int i = 0; i < noDealFileds.size(); i++) {
            String valueName = noDealFileds.get(i);//变量名字
            String valueType = noDealFiledTypes.get(i);//变量的类型
            valueType=getTypePath(valueType);

            //根据变量的类型，变量的名字，变量将要在的类 创建一个变量
             CtField ctField = null;
             try {
                 ctField = new CtField(ClassPool.getDefault().get(valueType), valueName, ctClass);
             } catch (CannotCompileException e) {
                 System.out.println("找不到了3："+e.getMessage());
             } catch (NotFoundException e) {
                 System.out.println("找不到了4："+e.getMessage());
             }
             ctField.setModifiers(Modifier.PUBLIC);//设置权限范围是私有的，或者public等

             if(noDealFiledExplains.size()!=0){
                 //参数设置描述
                 String apiModelPropertyValue = (apiModelPropertyValue=noDealFiledExplains.get(i))==null?"无描述":apiModelPropertyValue;//参数描述

                 System.out.println(apiModelPropertyValue);

                 if (StringUtils.isNotBlank(apiModelPropertyValue)) { //添加model属性说明
                     ConstPool constPool = ctClass.getClassFile().getConstPool();
                     AnnotationsAttribute attr = new AnnotationsAttribute(constPool, AnnotationsAttribute.visibleTag);
                     Annotation ann = new Annotation(ApiModelProperty.class.getName(), constPool);
                     ann.addMemberValue("value", new StringMemberValue(apiModelPropertyValue,constPool));
                     attr.addAnnotation(ann);

                     ctField.getFieldInfo().addAttribute(attr);
                 }

             }

             //把此变量添加到类中
             try {
                 ctClass.addField(ctField);
             } catch (CannotCompileException e) {
                 System.out.println("无法添加字段2："+e.getMessage());
             }

         }

    }
}