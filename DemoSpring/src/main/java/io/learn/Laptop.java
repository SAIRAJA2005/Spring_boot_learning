package io.learn;

import org.springframework.aop.scope.ScopedProxyUtils;

public class Laptop implements Computer {
    public Laptop(){
        System.out.println("I am Laptop Constructor!!");
    }

    public void compile(){
        System.out.println("I am laptop Compile method!!");
    }
}
