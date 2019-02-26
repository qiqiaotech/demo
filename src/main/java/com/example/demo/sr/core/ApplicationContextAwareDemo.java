package com.example.demo.sr.core;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ApplicationContextAwareDemo implements ApplicationContextAware, BeanNameAware, BeanPostProcessor, Ordered {

    ApplicationContext applicationContext;
    String beanName = "";

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanName(String s) {
        this.beanName = s;
    }

    public String getBeanName()  {
        return this.beanName;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
