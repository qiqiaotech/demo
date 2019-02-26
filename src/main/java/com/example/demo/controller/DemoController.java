package com.example.demo.controller;

import com.example.demo.sr.core.ApplicationContextAwareDemo;
import com.example.demo.sr.core.DynamicDIClass;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/getpage")
    public String getPage() {
        dynamicDIClass.setValue();

        return applicationContextAwareDemo.getBeanName();
    }
}
