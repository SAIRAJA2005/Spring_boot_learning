package com.myApp.myApp;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer{

    public void compile(){
        System.out.println("Hey i am compiler method!!");
    }
}
