package com.chx.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author chendikai
 * @date 2023-04-10 8:51
 */
@Configuration
@ComponentScan("com.chx.service")
public class SpringServiceConfig {
}
