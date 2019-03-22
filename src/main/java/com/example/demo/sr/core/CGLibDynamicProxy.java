package com.example.demo.sr.core;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLibDynamicProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        WrappedBefore();
        Object result = methodProxy.invokeSuper(o, objects);
        WrappedAfter();
        return result;
    }

    public void WrappedBefore() {
        System.out.println("before");
    }

    public void WrappedAfter() {
        System.out.println("after");
    }

    public <T> T getProxy(Class cls) {
        return (T)Enhancer.create(cls, this);
    }
}
