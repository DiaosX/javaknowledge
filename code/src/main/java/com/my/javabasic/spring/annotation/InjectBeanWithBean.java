package com.my.javabasic.spring.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


/**
 * @Bean注解用于注入bean工厂方法，主要用在@Component注解的类或者@Configuration标记的类中的方法上
 */
@Component
public class InjectBeanWithBean {

    private String injectName = "InjectBeanWithBean";

    public void setInjectName(String injectName) {
        this.injectName = injectName;
    }

    public String getInjectName() {
        return injectName;
    }

    @Primary
    @Bean(name = "instance1")
    public InjectBeanWithBean qualifierConstructor() {
        InjectBeanWithBean bean = new InjectBeanWithBean();
        bean.setInjectName("instance1");
        return bean;
    }

    @Bean(name = "instance2")
    public InjectBeanWithBean qualifierSetter() {

        InjectBeanWithBean bean = new InjectBeanWithBean();
        bean.setInjectName("instance2");
        return bean;
    }

    @Bean(name = "instance3")
    public InjectBeanWithBean qualifierField() {
        InjectBeanWithBean bean = new InjectBeanWithBean();
        bean.setInjectName("instance3");
        return bean;
    }
}
