package com.my.javabasic.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * 实例化处理器
 */
@Component
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    /**
     * bean 实例化之前执行
     *
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Nullable
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if ("myBean".equals(beanName)) {
            System.out.println(MyApplicationContextAware.nextStep() + ",bean初始化之前执行");
        }
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if ("myBean".equals(beanName)) {
            System.out.println(MyApplicationContextAware.nextStep() + ",bean初始化之后执行");
        }
        return false;
    }
}
