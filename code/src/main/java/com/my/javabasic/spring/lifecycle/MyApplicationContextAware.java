package com.my.javabasic.spring.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


/**
 * 提供一种方式获取spring的ApplicationContext，只要实现接口ApplicationContextAware后，spring自动会调用
 * setApplicationContext方法，然后获得ApplicationContext对象
 * 也可以通过spingboot的 SpringApplication.run方法获得，此方法返回的既是ApplicationContext对象
 */
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
