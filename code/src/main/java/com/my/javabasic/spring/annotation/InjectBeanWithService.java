package com.my.javabasic.spring.annotation;

import org.springframework.stereotype.Service;

/**
 * 通过Service注解注入bean
 */
@Service
public class InjectBeanWithService {
    private String injectName = "InjectBeanWithService";

    public String getInjectName() {
        return injectName;
    }
}
