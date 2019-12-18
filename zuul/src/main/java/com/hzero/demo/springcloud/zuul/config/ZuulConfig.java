package com.hzero.demo.springcloud.zuul.config;

import com.hzero.demo.springcloud.zuul.filter.AuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置自定义过滤器
 */
@Configuration
public class ZuulConfig {

    @Bean
    public AuthFilter authFilter() {
        return new AuthFilter();
    }

}
