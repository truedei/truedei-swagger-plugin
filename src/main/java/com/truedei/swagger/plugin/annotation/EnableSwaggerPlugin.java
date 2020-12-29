package com.truedei.swagger.plugin.annotation;

import com.truedei.swagger.plugin.configuration.EnableSwaggerPluginConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;


/**
 * @author zhenghui
 * @date 2020/12/22 21:16
 * @desc 作用：此项目的开关
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({EnableSwaggerPluginConfiguration.class })
public @interface EnableSwaggerPlugin {

}
