package com.saveli.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = { "controller", "model", "proxy", "service","repository"})
@EnableAspectJAutoProxy
@EnableWebMvc
public class SpringConfign implements WebMvcConfigurer{
    // @Bean
    // public InternalResourceViewResolver defaultViewResolver() {
    //     return new InternalResourceViewResolver();
    // }
}
