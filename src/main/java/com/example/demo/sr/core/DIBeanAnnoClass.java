package com.example.demo.sr.core;

public class DIBeanAnnoClass {

    public DIBeanAnnoClass() {
        System.out.println("constructor in DIBeanAnnoClass");
    }

    public String getDIBeanAnnoClassName() {
        return this.getClass().getName();
    }
}
