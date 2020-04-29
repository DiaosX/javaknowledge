package com.my.javabasic.spring.aop.annotationaspect;

import org.springframework.stereotype.Component;

@Component
public class AnnotationSubject {
    @EnableAnnotationAspect
    public String getHelloMessage(boolean withException) throws Exception {
        if (withException) {
            throw new Exception("发生异常了");
        }
        System.out.println("Hello AnnotationSubject.");
        return "Hello";
    }
}
