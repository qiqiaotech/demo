package com.example.demo.sr.core.TestClass;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//使用@Configuration和@Component有区别，
// 前者将处理@Bean之间的依赖使用ClassC singleton，
// 后者不处理而是直接new两个不同的ClassC的实例,spring reference core 1.12.4
@Component
public class ConfigClass {

    @Bean
    public ClassA injuctClassA() {
        ClassC classC = injuctClassC();
        classC.setCString("set String in injuctClassA");
        ClassA classA = new ClassA(classC);
        System.out.println("injuctClassA: " + classA.getCString() + classA.toString());
        return classA;
    }

    @Bean
    public ClassA injuctClassAA() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        Iterator it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>)it.next();
            entry.getKey();

        }

        ClassA classA = new ClassA(injuctClassC());
        System.out.println("injuctClassAA: " + classA.getCString() + classA.toString());
        return classA;
    }

    @Bean
    ClassC injuctClassC() {
        return new ClassC();
    }
}
