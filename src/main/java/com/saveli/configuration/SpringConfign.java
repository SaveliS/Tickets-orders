package com.saveli.configuration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.saveli.aspect.LoggingAspect;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = { "controller", "model", "proxy", "service", "repository" })
public class SpringConfign {
    /* Добавляю в Логгер в констекст Spring.*/
    @Bean
    public LoggingAspect loggingAspect() {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/main/resources/application.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(properties.getProperty("absolute.path.logger"));
        return new LoggingAspect(properties.getProperty("absolute.path.logger"));
    }

}
