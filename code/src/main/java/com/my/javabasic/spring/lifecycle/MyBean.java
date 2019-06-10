package com.my.javabasic.spring.lifecycle;


import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


/*
 * Bean级生命周期接口: 在org.springframework.beans.factory 下，它们是Bean级生命周期接口，这些接口由Bean类直接实现
 *
 * BeanNameAware=>void setBeanName(String beanName),待对象实例化并设置属性之后调用该方法设置BeanName
 * InitializingBean=>void afterPropertiesSet() throws Exception,实例化完成之后调用（调用了BeanPostProcessor.postProcessBeforeInitialization方法之后调用该方法）
 * BeanFactoryAware=> void setBeanFactory(BeanFactory var1) throws BeansException, 待调用setBeanName之后调用该方法设置BeanFactory，BeanFactory对象默认实现类是DefaultListableBeanFactory
 * DisposableBean=> void destroy() throws Exception, 关闭容器时调用
 */

/*
*容器级Bean生命周期接口:
*
* InstantiationAwareBeanPostProcessorAdapter:实例化前／后，及框架设置Bean属性时调用该接口。可覆盖的常用方法有：
* 接口BeanPostProcessor:实例化完成之后调用该接口
*
* org.springframework.beans.factory.config 下，一般称它们的实现类为“后处理器”。
* 后处理器接口一般不由Bean本身实现，实现类以容器附加装置的形式注册到Spring容器中。
* 当Sprig容器创建任何Bean的时候，这两个后处理器都会发生作用，所以这两个后处理器的影响是全局的
*
*
 */

/*
Bean级生命周期接口解决Bean个性化处理的问题，Bean容器级生命周期接口解决容器中某些Bean共性化处理的问题。
 */

/*
Bean的作用域：
Singleton: spring默认缺省的，全局只有一个对象
prototype:每次获取bean时，容器都都创建新的实例返回，有状态的Bean建议用此类型
request:每次Http请求都会创建bean,仅在当前Http Request内有效,仅适用于WebApplicationContext环境
session:同一个http请求共享一个bean,不通session使用不通的bean,仅在当前Session内有效。仅使用于WebApplicationContext
global session:一个全局的Http Session中，容器返回同一个实例Bean。

 */


@Component
@Scope("singleton")
public class MyBean implements BeanNameAware, InitializingBean {
    public MyBean() {
        System.out.println(MyApplicationContextAware.nextStep() + ",MyBean的构造器");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String name;
    private int age;

    @Override
    public void setBeanName(String name) {
        System.out.println(MyApplicationContextAware.nextStep() + ",BeanNameAware.setBeanName(),BeanName=" + name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(MyApplicationContextAware.nextStep() + ",InitializingBean.afterPropertiesSet()");
    }

    @PostConstruct
    public void init() {
        System.out.println(MyApplicationContextAware.nextStep() + ",Mybean.init()");
    }
}
