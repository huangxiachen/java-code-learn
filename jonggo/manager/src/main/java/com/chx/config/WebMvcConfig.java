package com.chx.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     * 静态资源文件映射配置
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith("win")) {  //如果是Windows系统
            registry.addResourceHandler("/img/**").addResourceLocations("file:" + "c:/testFile/");
        } else { //linux和mac系统
            registry.addResourceHandler("/img/**").addResourceLocations("file:" + "c:/testFile/");
        }
    }
}