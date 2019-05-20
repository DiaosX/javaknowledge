package com.my.javabasic.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationContextAware implements ApplicationContextAware {
    private static ApplicationContext context;
    private static Integer step = 0;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        System.out.println(MyApplicationContextAware.nextStep() + ",ApplicationContextAware.setApplicationContext");
        MyApplicationContextAware.context = context;
    }

    public static ApplicationContext getContext() {
        return MyApplicationContextAware.context;
    }

    public static Integer nextStep() {
        step++;
        return step;
    }
}
