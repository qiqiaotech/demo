package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
@ServletComponentScan
//引入xml配置
//@ImportResource(locations={"classpath:spring-beans.xml"})
public class DemoApplication {

    public static void main(String[] args) {
        //ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
        SpringApplication.run(DemoApplication.class, args);
    }

}
