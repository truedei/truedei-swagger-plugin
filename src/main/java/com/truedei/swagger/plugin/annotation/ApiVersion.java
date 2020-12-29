package com.truedei.swagger.plugin.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * @author zhenghui
 * @date 2020年11月2日12:02:00
 * @desc 作用：接口版本管理注解（可以指定某借口的版本，进行分组）
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ApiVersion {

    /**
     * 接口版本号（对应swagger中的group）
     * @return
     */
    String [] group();

}
