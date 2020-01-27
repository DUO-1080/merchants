package com.avondrix.merchants.config;

import com.avondrix.merchants.security.AuthCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;

@Configuration
public class MerchantsConfig extends WebMvcConfigurationSupport {

    @Resource
    private AuthCheckInterceptor authCheckInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(authCheckInterceptor)
                .addPathPatterns("/merchants/**");
    }
}
