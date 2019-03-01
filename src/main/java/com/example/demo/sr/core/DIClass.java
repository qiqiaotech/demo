package com.example.demo.sr.core;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DIClass implements DIInterface {

    private String diClassString;

    public DIClass(String s) { this.diClassString = s;}

    public DIClass() {
        this.diClassString ="default string in DIClass";
    }

    public String getString() {
        return diClassString;
    }
}
