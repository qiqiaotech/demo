package com.example.demo.sr.core;

import com.example.demo.sr.core.proxy.TestObj;
import com.example.demo.sr.core.proxy.TestObjImpl;

public class StudyProxy {

    public static void main(String[] args) {
        System.out.println("main");
        TestObj test = new JDKDynamicProxy(new TestObjImpl()).getProxy();
        test.showMessage();
    }
}
