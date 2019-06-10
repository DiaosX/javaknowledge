package com.my.javabasic.spring.annotation;

import org.springframework.stereotype.Controller;

/**
 * 通过Controller注解注入bean
 */
@Controller
public class InjectBeanWithController {

    private String injectName = "InjectBeanWithController";

    public String getInjectName() {
        return injectName;
    }
}
