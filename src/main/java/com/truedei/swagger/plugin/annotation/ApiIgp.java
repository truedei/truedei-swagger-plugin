package com.truedei.swagger.plugin.annotation;

import com.truedei.swagger.plugin.bean.DefaultModel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhenghui
 * @date 2020年9月17日17:00:49
 * @desc 排除不需要的属性的值
 */
@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiIgp {


    /**
     * 对象的原始class地址，非必填
     */
    Class<?> classPath() default DefaultModel.class;

    /**
     * 自定义 Model的名字，非必填
     */
    String modelName() default "";

    /**
     * 原始对象中已经存在的对象属性名字 ，非必填
     */
    String values()[] default {};

    /**
     * 原始对象中不存在的对象属性名字，非必填
     */
    String noValues()[] default {} ;

    /**
     * 原始对象中不存在的对象属性的类型，基本类型例如：String等，非必填
     */
    String noValueTypes()[] default {};

    /**
     * 自定义变量的参数说明 非必填
     */
    String noVlaueExplains()[] default {};

    /**
     * 参数是否必填
     */
    boolean noVlaueRequired()[] default {};

    /**
     * 参数的顺序
     * 此功能，暂时未实现
     */
    @Deprecated
    int noVlauePosition()[] default {};


    /**
     * 参数实例
     */
    String noVlaueExample()[] default {};


}
 
