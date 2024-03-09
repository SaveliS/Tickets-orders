package com.saveli.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

import com.saveli.repository.CustomerRepository;
import com.saveli.service.CustomerService;

@Configuration
@ComponentScan(basePackages = {"controller","model","proxy"})
@EnableJdbcRepositories(basePackages = {"repository","service"})
@EntityScan(basePackages = {"com.saveli"})
public class SpringConfign {
    // @Bean
    // public JdbcMappingContext jdbcMappingContext() {
    //     return new JdbcMappingContext();
    // }
}
