package com.my.javabasic.spring.annotation;

import org.springframework.stereotype.Repository;


/**
 * 通过Repository注解注入bean
 */
@Repository
public class InjectBeanWithRepository {

    private String injectName = "InjectBeanWithRepository";

    public String getInjectName() {
        return injectName;
    }
}
