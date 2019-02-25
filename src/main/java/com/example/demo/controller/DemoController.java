package com.example.demo.controller;

import com.example.demo.sr.core.DynamicDIClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    DynamicDIClass dynamicDIClass;

    @RequestMapping("/getpage")
    public String getPage() {
        dynamicDIClass.setValue();
        return "getpage.html";
    }
}
