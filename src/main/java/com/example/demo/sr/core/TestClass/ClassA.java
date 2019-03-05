package com.example.demo.sr.core.TestClass;

public class ClassA {
    private ClassC classCInA;

    public ClassA(ClassC clazz) {
        this.classCInA = clazz;
    }

    public String getCString() {
        return classCInA.getCString();
    }
}
