package com.example.demo.aop;

import java.lang.reflect.Method;

import org.apache.commons.lang3.time.StopWatch;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeLogAspect {
    @Value("${aop.logging}")
    private boolean logging;

    @Around("@annotation(TimeLog)")
    public Object logElapsedTime(ProceedingJoinPoint joinPoint) throws Throwable {

        if (logging) {
            StopWatch watch = new StopWatch();
            watch.start();

            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod();

            final Object proceed = joinPoint.proceed();
            watch.stop();
            System.out.println("Method Name: " + method.getName() + "Time Elapsed: " + watch.getTime());

            return proceed;
        } else {
            return joinPoint.proceed();
        }
    }

}