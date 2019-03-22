package com.example.demo.sr.core;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class DynamicDIClass implements ApplicationContextAware {

    private String value ="";

    private String requiredString;

    private ApplicationContext applicationContext;

    private DIClass diClass;  //使用唯一构造函数注入，可省略@Autowired

    @Autowired   //Map自动注入DIInterface接口的两个实现类实例
    //@Qualifier("DIInterfaceImpl")
    private Map<String, DIInterface> mapDIInterface;

    @Autowired     //List自动注入DIInterface接口的两个实现类实例
    private List<DIInterface> listDIInterface;

    @Autowired
    private SpringDynamicService springDynamicService;

    public void setValue(String value) {
        this.value = value;
    }

    public void getValue() {
        System.out.println(value);
    }

    public void setRequiredString(String s) {
        this.requiredString = s;
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
        System.out.println(diClass.getString());

        //自动注入MAP的输出
        if ((null != mapDIInterface) && (0< mapDIInterface.size())) {
            for (Map.Entry<String, DIInterface> item : mapDIInterface.entrySet()) {
                System.out.println(item.getKey() + ": " + item.getValue());
            }
        }

        //Autowired自动注入List的输出
        for(DIInterface item : listDIInterface) {
            System.out.println(item.getClass().getName());
        }

        //spring proxy输出测试
        springDynamicService.testSpringProxy();
    }

    public DynamicDIClass(DIClass diClass) {
        this.diClass = diClass;
        System.out.println("DynamicDIClass构造");
    }
}
