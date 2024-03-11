package com.saveli.aspect;

import java.io.File;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import com.saveli.logging.CreateLogs;

@Aspect // Не стереотипная. Не будет добавлена в контекст.
public class LoggingAspect {

    private String loggingPathFile;
    private File writerFile;
    private CreateLogs createLogs;

    public LoggingAspect(String loggingPathFile){
        createLogs = new CreateLogs();
        writerFile = createLogs.GenerateLogsFile(createLogs.GenerateNameFile(), loggingPathFile);
        this.loggingPathFile = loggingPathFile;
    }

    @Around("execution(* service.*.*(..))")
    public void log(ProceedingJoinPoint joinPoint) throws Throwable{
        createLogs.CreateLog("Метод запущен", writerFile);
        joinPoint.proceed();
        createLogs.CreateLog("Метод закончен", writerFile);
    }    
}
