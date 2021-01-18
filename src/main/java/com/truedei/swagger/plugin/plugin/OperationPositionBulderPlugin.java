
package com.truedei.swagger.plugin.plugin;

import com.fasterxml.classmate.TypeResolver;
import com.truedei.swagger.plugin.annotation.APiFileInfo;
import com.truedei.swagger.plugin.bean.APiFileInfoBean;
import com.truedei.swagger.plugin.bean.SwaggerPluginConfigBean;
import com.truedei.swagger.plugin.util.MdToHtml;
import com.truedei.swagger.plugin.io.ResolverUtil;
import com.google.common.base.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.OperationBuilderPlugin;
import springfox.documentation.spi.service.contexts.OperationContext;

import java.util.*;


/**
 * 针对方法自定义注解
 * @author zhenghui
 * @date 2020年9月13日13:25:18
 * @desc 读取自定义的属性并动态生成model
 * OperationBuilderPlugin：对方法起作用
 */
@Component
@Order(1)
public class OperationPositionBulderPlugin implements OperationBuilderPlugin {

    private static final Logger logger = LoggerFactory.getLogger(OperationPositionBulderPlugin.class);

    private static Map<String, Map<String, Object>>  apiFileInfoMaps = null;

    private static List<String> swaggerMdPaths  = new ArrayList<>();

    private static boolean flag = false;

    @Autowired
    private SwaggerPluginConfigBean swaggerPluginConfigBean;

    @Override
    public void apply(OperationContext context) {
        //一、如果之前没有加载文件内容，就先加载
        if(swaggerMdPaths.size()==0){

            String packageName = "com.glodon";

            if(swaggerPluginConfigBean != null && swaggerPluginConfigBean.getScan() != null
                    && swaggerPluginConfigBean.getScan().getPath() != null){
                packageName = swaggerPluginConfigBean.getScan().getPath();
            }

            //扫描项目中的md文档
            findMdDirectory(packageName);
            config(context);

            //内容已存在就直接加载
        }else{
            if(flag){
                config(context);
            }
        }

    }

    private void findMdDirectory(String packageName) {
        if(apiFileInfoMaps == null || apiFileInfoMaps.size()==0) {

            ResolverUtil resolverUtil = new ResolverUtil();
            resolverUtil.find(packageName);

            if(swaggerPluginConfigBean.isDebug()){
                logger.info("开始解析文件了----->"+packageName);
            }

            //读取并文件内容
            apiFileInfoMaps = resolverUtil.getFileContentMap();

            //如果==null说明文件中没有内容，或者文件夹中不存在文件等情况
            flag = (apiFileInfoMaps == null ? false : true);
        }

    }

    private void config(OperationContext context){

        if(flag){

            //2、查找APiFileInfo注解，
            Optional<APiFileInfo> apiFileInfoOptional = context.findAnnotation(APiFileInfo.class);

            if (apiFileInfoOptional.isPresent()) {
                String flag = null;//获取URL（URL作用是定位到）

                flag = apiFileInfoOptional.get().value();//获取标志，标志：在文件中所在的位置

                if(swaggerPluginConfigBean.isDebug()){
                    logger.info("正在构建：--->【"+flag+"】接口");
                }

                String notes = buildNotes(flag, apiFileInfoMaps);

                if(notes!=null && !"".equals(notes.trim())){
                    //构建消息
                    context.operationBuilder()
                            .responseMessages(buildResponseMessage(flag, apiFileInfoMaps)) //重构responseMessage响应消息
                            .notes(notes==null?"":notes); //重构接口描述
                }else if(notes==null || "".equals(notes.trim())){
                    //构建消息
                    context.operationBuilder()
                            .responseMessages(buildResponseMessage(flag, apiFileInfoMaps)); //重构responseMessage响应消息
                }
                else{
                    if(swaggerPluginConfigBean.isDebug()){
                        logger.warn("在文件中不存在：--->"+flag);
                    }
                }

            }
        }else {
            if(swaggerPluginConfigBean.isDebug()){
                logger.warn("没有文件，不加载：--->"+flag);
            }
        }
    }


    /**
     * 构建接口描述信息
     * @param flag 接口flag
     * @param apiFileInfoMaps
     * @return
     */
    private String buildNotes(String flag, Map<String, Map<String, Object>> apiFileInfoMaps) {
        Map<String, Object> map = apiFileInfoMaps.get(flag);

        Object miaoshu = null;
        if(map!=null){
            miaoshu = map.get("miaoshu");
        }
        return (map!=null && miaoshu!=null) ? MdToHtml.convert(miaoshu.toString()) : null;
    }

    /**
     * 构造ResponseMessage
     * @param flag 该消息说明描述的文本所在的位置
     * @param apiFileInfoMaps
     * @return
     */
    private Set<ResponseMessage> buildResponseMessage(String flag, Map<String, Map<String, Object>> apiFileInfoMaps) {
        Map<String, Object> map = apiFileInfoMaps.get(flag);

        Set<ResponseMessage> set = new HashSet<>();
        ResponseMessage responseMessage = null;

        if(map!=null){
            Object codes = map.get("codes");
            if(codes!=null){
                Map<Integer, APiFileInfoBean> codeMap = (Map<Integer, APiFileInfoBean>)codes;

                if(codeMap!=null){
                    for (Map.Entry<Integer, APiFileInfoBean> entry : codeMap.entrySet()) {
                        responseMessage = new ResponseMessageBuilder()
                                .code(entry.getKey())
                                .message(MdToHtml.makdownToHtml(entry.getValue().getMessage()))
                                .build();
                        set.add(responseMessage);
                    }
                }
            }
        }
        return set;
    }



    /**
     * 扩展Swagger功能时，必须要存在的
     * @param delimiter
     * @return
     */
    @Override
    public boolean supports(DocumentationType delimiter) {
        return true;
    }



}
