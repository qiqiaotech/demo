package com.example.demo.sr.core;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class DynamicDIClass implements ApplicationContextAware {

    private String value ="";

    private ApplicationContext applicationContext;

    public void setValue(String value) {
        this.value = value;
    }

    public void getValue() {
        System.out.println(value);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;

    }

    public void setValue() {
        DynamicDIClass clzA = (DynamicDIClass) applicationContext.getBean("dynamicDIClass", DynamicDIClass.class);
        clzA.setValue("this is a class value");
        DynamicDIClass clzB = (DynamicDIClass) applicationContext.getBean("dynamicDIClass", DynamicDIClass.class);
        clzB.setValue("this is b class value");

        clzA.getValue();
        clzB.getValue();
    }

    @Autowired
    public DynamicDIClass() {
        System.out.println("DynamicDIClass output");
    }
}
