package com.my.javabasic.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 字段注入方式
 */
@Component
public class InjectByField {

    @Autowired(required = true)
    private InjectBeanWithComponent componentBean;
    @Autowired(required = true)
    private InjectBeanWithService serviceBean;
    @Autowired(required = true)
    private InjectBeanWithController controllerBean;
    @Autowired(required = true)
    private InjectBeanWithRepository repositoryBean;
    @Autowired(required = true)
    private InjectBeanWithBean beanBean;

    @Override
    public String toString() {
        return "通过字段注入：" + componentBean.getInjectName() + "," +
                serviceBean.getInjectName() + "," +
                controllerBean.getInjectName() + "," +
                repositoryBean.getInjectName() + "," +
                beanBean.getInjectName();
    }
}
