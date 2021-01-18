package com.truedei.swagger.plugin.configuration;

import com.truedei.swagger.plugin.bean.SwaggerPluginConfigBean;
import com.truedei.swagger.plugin.util.SpringUtil;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring IOC同意管理对象
 */
@Configuration
public class SwaggerPluginConfig {


    @ConfigurationProperties(prefix = "swagger-plugin")
    @Bean(name = "swaggerPluginConfigBean")
    public SwaggerPluginConfigBean getSwaggerPluginConfigBean(){
        return new SwaggerPluginConfigBean();
    }

    @Bean
    public SpringUtil springUtil(){
        return new SpringUtil();
    }



}
