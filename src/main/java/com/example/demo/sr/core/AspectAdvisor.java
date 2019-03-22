package com.example.demo.sr.core;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectAdvisor {

    @Around("@annotation(com.example.demo.sr.core.annotation.Tag)")
    public Object around(ProceedingJoinPoint cutPoint) throws Throwable {
        System.out.println("Arrond AspectJAdvisor(Before): " + cutPoint.getSignature().getDeclaringTypeName());
        Object result = cutPoint.proceed();
        System.out.println("Arrond AspectJAdvisor(After): " + cutPoint.getSignature().getDeclaringTypeName());
        return result;
    }
}
