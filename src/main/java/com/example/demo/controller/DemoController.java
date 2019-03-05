package com.example.demo.controller;

import com.example.demo.sr.core.ApplicationContextAwareDemo;
import com.example.demo.sr.core.DIBeanAnnoClass;
import com.example.demo.sr.core.DynamicDIClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.Controller;

import javax.annotation.Resource;

@RestController
public class DemoController {

    @Resource
    private DynamicDIClass dynamicDIClass;

    @Resource
    private ApplicationContextAwareDemo applicationContextAwareDemo;

    @Autowired
    ApplicationContext applicationContext;

    @RequestMapping("/getpage")
    public String getPage() {
        dynamicDIClass.setValue();

        //测试@Bean(name=xxx)创建并注入BEAN
        DIBeanAnnoClass diBeanAnnoClass = (DIBeanAnnoClass) applicationContext.getBean("testBean");
        System.out.println(diBeanAnnoClass.getDIBeanAnnoClassName());

        return applicationContextAwareDemo.getBeanName();
    }
}
