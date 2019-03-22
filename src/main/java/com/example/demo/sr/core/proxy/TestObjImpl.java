package com.example.demo.sr.core.proxy;

import com.example.demo.sr.core.annotation.Tag;

public class TestObjImpl implements TestObj {

        @Override
        public void showMessage() {
            System.out.println("showMessage in TestObjImpl");
        }
}
