package com.my.javabasic.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * setter注入方式
 */
@Component
public class InjectBySetter {
    private InjectBeanWithComponent componentBean;
    private InjectBeanWithService serviceBean;
    private InjectBeanWithController controllerBean;
    private InjectBeanWithRepository repositoryBean;
    private InjectBeanWithBean setterBean;
    private InjectBeanWithBean beanBean;

    @Autowired(required = true)
    public void setComponentBean(InjectBeanWithComponent componentBean) {
        this.componentBean = componentBean;
    }

    @Autowired(required = true)
    public void setServiceBean(InjectBeanWithService serviceBean) {
        this.serviceBean = serviceBean;
    }

    @Autowired(required = true)
    public void setControllerBean(InjectBeanWithController controllerBean) {
        this.controllerBean = controllerBean;
    }

    @Autowired(required = true)
    public void setRepositoryBean(InjectBeanWithRepository repositoryBean) {
        this.repositoryBean = repositoryBean;
    }

    @Autowired(required = true)
    public void setBeanBean(InjectBeanWithBean beanBean) {
        this.beanBean = beanBean;
    }

    @Autowired(required = true)
    public void setSetterBean(@Qualifier(value = "instance2") InjectBeanWithBean beanBean) {
        this.setterBean = beanBean;
        System.out.println(this.setterBean.getInjectName());
    }


    @Override
    public String toString() {
        return "通过Setter注入：" + componentBean.getInjectName() + "," +
                serviceBean.getInjectName() + "," +
                controllerBean.getInjectName() + "," +
                repositoryBean.getInjectName() + "," +
                beanBean.getInjectName();
    }
}
