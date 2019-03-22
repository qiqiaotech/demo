package com.example.demo.sr.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKDynamicProxy implements InvocationHandler {

    private Object target;

    public JDKDynamicProxy(Object target) {
        this.target = target;
    }

    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        WrappedBefore();
        Object result = method.invoke(target, args);
        WrappedAfter();
        return result;
    }

    public void WrappedBefore() {
        System.out.println("before");
    }

    public void WrappedAfter() {
        System.out.println("after");
    }

}
