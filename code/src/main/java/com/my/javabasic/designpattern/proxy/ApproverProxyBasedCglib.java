package com.my.javabasic.designpattern.proxy;

import org.springframework.cglib.proxy.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 基于Cglib的动态代理，可以代理单个对象
 * CGlib动态代理是通过继承业务类，生成的动态代理类是业务类的子类，通过重写业务方法进行代理
 */
public class ApproverProxyBasedCglib implements MethodInterceptor {
    private Object approver;

    public Object newProxyInstance(Object targetObject) {

        this.approver = targetObject;
        Enhancer enhancer = new Enhancer();
        //设置代理类，作为代理的父类
        enhancer.setSuperclass(this.approver.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        String currentMethodName = method.getName();
        System.out.println("ApproverProxyBasedCglib-" + currentMethodName + "-before invoke");
        Object result = method.invoke(approver, objects);
        System.out.println("ApproverProxyBasedCglib-" + currentMethodName + "-after invoke");
        return result;
    }
}
