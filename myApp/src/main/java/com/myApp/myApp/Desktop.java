package com.myApp.myApp;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Desktop implements Computer{

    public void compile(){
        System.out.println("Hey i am compiler method from the Desktop interface!!");
    }
}
