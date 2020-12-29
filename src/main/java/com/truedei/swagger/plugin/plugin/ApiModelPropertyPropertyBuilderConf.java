//package com.glodon.swagger.plugin.plugin;
//
//import io.swagger.annotations.ApiModelProperty;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.AnnotationUtils;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//import springfox.documentation.spi.schema.contexts.ModelPropertyContext;
//import springfox.documentation.spring.web.DescriptionResolver;
//import springfox.documentation.swagger.schema.ApiModelPropertyPropertyBuilder;
//
//@Component
//@Order(Ordered.LOWEST_PRECEDENCE)
//public class ApiModelPropertyPropertyBuilderConf extends ApiModelPropertyPropertyBuilder {
//    public ApiModelPropertyPropertyBuilderConf(DescriptionResolver descriptions) {
//        super(descriptions);
//    }
//
//    static AnnotationConfigApplicationContext context1;
//    static boolean isEnbale = false;
//
//    static {
//        ApplicationContext context = new AnnotationConfigApplicationContext();
//
//        String[] beanDefinitionNames = context.getBeanDefinitionNames();
//        System.out.println("beanDefinitionNames:");
//        for (String beanDefinitionName : beanDefinitionNames) {
//            System.out.println(beanDefinitionName);
//        }
//    }
//
//    @Override
//    public void apply(ModelPropertyContext context) {
//
//        context1 = new AnnotationConfigApplicationContext();
//        context1.scan("cn.service.*");
//        context1.refresh();
//        isEnbale  = context1.containsBean(ApiModelPropertyPropertyBuilderConf.class.getName());
////        System.out.println("是否存在："+context.containsBean(CounterService.class.toString()));
////        System.out.println("是否存在："+context.containsBean(LoggerService.class.getName()));
////        System.out.println("是否存在："+context.containsBean(MonitorService.class.getName()));
//
//        if(isEnbale) {
////            System.out.println("我开启了啦啦啦啦啦啦啦啦绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿");
//            if (context.getAnnotatedElement().isPresent()) {
//                ApiModelProperty model = AnnotationUtils.getAnnotation(context.getAnnotatedElement().get(), ApiModelProperty.class);
//                if (model != null) {
//                    return;
//                }
//            }
//        }else{
////            System.out.println("未开启");
//        }
//
//    }
//}