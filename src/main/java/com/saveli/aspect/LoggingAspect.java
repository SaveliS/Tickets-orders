package com.saveli.aspect;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.saveli.logging.CreateLogs;

@Aspect // Не стереотипная. Не будет добавлена в контекст.
@Component
public class LoggingAspect {
    private CreateLogs createLogs = new CreateLogs();

    public LoggingAspect(){

    }

    @Pointcut("@annotation(ToLog)")
    public void loggableMethod(){

    }

    @Around("loggableMethod()")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable{
        createLogs.CreateLog("Метод запущен");
        createLogs.CreateLog("Имя метода:" + joinPoint.getClass().getName());
        createLogs.CreateLog("Метод закончен");
        return joinPoint.proceed();
    }    
}
