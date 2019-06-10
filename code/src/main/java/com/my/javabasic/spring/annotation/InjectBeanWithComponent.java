package com.my.javabasic.spring.annotation;

import org.springframework.stereotype.Component;


/**
 * 通过Component注解注入bean
 */
@Component
public class InjectBeanWithComponent {

    private String injectName = "InjectBeanWithComponent";

    public String getInjectName() {
        return injectName;
    }
}
