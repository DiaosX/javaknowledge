package com.my.javabasic.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InjectByConstructor {

    private InjectBeanWithComponent componentBean;
    private InjectBeanWithService serviceBean;
    private InjectBeanWithController controllerBean;
    private InjectBeanWithRepository repositoryBean;
    private InjectBeanWithBean beanBean;

    /**
     * 通过构造函数注入
     * 构造器注入的好处：
     * 1.保证依赖不可变
     * 2.保证依赖不为空
     * 3.保证返回客户端（调用）的代码的时候是完全初始化的状态
     * 4.避免了循环依赖,属性注入在初始化的时候不报错，在使用时才会报错
     * 5.提升了代码的可复用性
     *
     * @param componentBean
     * @param serviceBean
     * @param controllerBean
     * @param repositoryBean
     * @param beanBean
     */
    @Autowired
    public InjectByConstructor(InjectBeanWithComponent componentBean,
                               InjectBeanWithService serviceBean,
                               InjectBeanWithController controllerBean,
                               InjectBeanWithRepository repositoryBean,
                               InjectBeanWithBean beanBean) {

        this.componentBean = componentBean;
        this.serviceBean = serviceBean;
        this.controllerBean = controllerBean;
        this.repositoryBean = repositoryBean;
        this.beanBean = beanBean;
    }

    @Override
    public String toString() {
        return "通过构造器注入：" + componentBean.getInjectName() + "," +
                serviceBean.getInjectName() + "," +
                controllerBean.getInjectName() + "," +
                repositoryBean.getInjectName() + "," +
                beanBean.getInjectName();
    }
}
