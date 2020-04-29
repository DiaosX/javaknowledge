package com.my.javabasic.spring.aop.pointcutaspect;

import org.springframework.stereotype.Component;

@Component
public class Subject {
    public void sayHello(boolean withException) throws Exception {
        if (withException) {
            throw new Exception("发生异常了");
        }
        System.out.println("Hello Aspect.");
    }
}
