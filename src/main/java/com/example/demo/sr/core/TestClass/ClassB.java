package com.example.demo.sr.core.TestClass;

public class ClassB {
    private ClassC classCInB;

    public ClassB(ClassC clazz) {
        this.classCInB = clazz;
    }

    public String getAString() {
        return classCInB.getCString();
    }
}
