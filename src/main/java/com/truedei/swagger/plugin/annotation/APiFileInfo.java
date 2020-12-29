package com.truedei.swagger.plugin.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhenghui
 * @date 2020年9月17日17:00:25
 * @desc 读取文件中的标记
 */
@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface APiFileInfo {

    String value() default "";//url,flag 在某文档中存放的一个标志
}
