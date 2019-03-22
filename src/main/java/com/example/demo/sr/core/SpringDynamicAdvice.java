package com.example.demo.sr.core;

import com.example.demo.sr.core.proxy.TestOtherObj;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;
import org.springframework.stereotype.Component;

@Component
public class SpringDynamicAdvice extends DelegatingIntroductionInterceptor implements TestOtherObj {  //MethodInterceptor
    @Override
    public void showOtherMessage() {
        System.out.println("Show Message In SpringDynamicAdvice");
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("Before: " + methodInvocation.getMethod().getName());
        //Object result = methodInvocation.proceed();
        Object result = super.invoke(methodInvocation);
        System.out.println("After: " + methodInvocation.getMethod().getName());

        return result;
    }
}
