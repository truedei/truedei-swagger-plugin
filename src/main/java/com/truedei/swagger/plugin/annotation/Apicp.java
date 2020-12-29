package com.truedei.swagger.plugin.annotation;

import com.truedei.swagger.plugin.bean.DefaultModel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhenghui
 * @date 2020年9月17日17:00:25
 * @desc 需要的属性的值
 */
@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Apicp {
    Class<?> classPath() default DefaultModel.class;//对象的原始class地址，非必填
    String modelName() default "";//自定义 Model的名字，非必填
    String values()[] default {}; //原始对象中已经存在的对象属性名字 ，非必填
    String noValues()[] default {} ;//原始对象中不存在的对象属性名字，非必填
    String noValueTypes()[] default {};//原始对象中不存在的对象属性的类型，基本类型例如：String等，非必填
    String noVlaueExplains()[] default {};//自定义变量的参数说明 非必填

}