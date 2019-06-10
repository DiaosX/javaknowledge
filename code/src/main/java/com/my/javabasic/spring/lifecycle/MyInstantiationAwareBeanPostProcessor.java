package com.my.javabasic.spring.lifecycle;

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


    /**
     * 当bean被初始化后执行，在属性赋值之前
     * 如果阻止属性注入，则返回false,并且当返回false时子的InstantiationAwareBeanPostProcessor实例也不会执行
     * 默认的实现返回true
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if ("myBean".equals(beanName)) {
            System.out.println(MyApplicationContextAware.nextStep() + ",bean初始化之后执行");
        }
        //如果期望属性注入，这里必须返回true
        return true;
    }
}
