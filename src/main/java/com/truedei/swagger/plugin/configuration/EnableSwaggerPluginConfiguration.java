package com.truedei.swagger.plugin.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 扫描，配置信息
 */
@Configuration
@ComponentScan(
        basePackages = {"com.truedei.swagger.plugin.*"}
)
public class EnableSwaggerPluginConfiguration {

}
