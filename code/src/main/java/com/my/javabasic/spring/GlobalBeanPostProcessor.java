package com.my.javabasic.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * BeanPostProcessor是全局的，对每个bean初始化都器作用
 */
@Component
public class GlobalBeanPostProcessor implements BeanPostProcessor {


    /**
     * 前置处理器
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("myBean".equals(beanName)) {
            System.out.println(MyApplicationContextAware.nextStep() + ",BeanPostProcessor.postProcessBeforeInitialization,beanName=" + beanName);
            MyBean myBean = (MyBean) bean;
            if (myBean.getName() == null) {
                System.out.println("调用BeanPostProcessor.postProcessBeforeInitialization,name为空");
                myBean.setName("myBean");
            }
        }
        return bean;
    }

    /**
     * 后置处理器
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("myBean".equals(beanName)) {
            System.out.println(MyApplicationContextAware.nextStep() + ",BeanPostProcessor.postProcessAfterInitialization,beanName=" + beanName);
            MyBean myBean = (MyBean) bean;
            if (myBean.getName() != null) {
                System.out.println(myBean.getName());
            }
        }
        return bean;
    }
}
