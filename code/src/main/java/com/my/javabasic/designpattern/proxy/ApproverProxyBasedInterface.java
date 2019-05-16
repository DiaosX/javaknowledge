package com.my.javabasic.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 基于接口的动态代理，此动态代理由JDK提供
 * 只能基于接口做代理，被代理的对象一定实现某些接口，相对于Cglib，接口代理不能代理对象实例
 * JDK动态代理是通过接口中的方法名，在动态生成的代理类中调用业务实现类的同名方法
 * <p>
 * <p>
 * 使用InvocationHandler接口定义动态代理步骤：
 * <p>
 * 1.定义目标接口
 * 2.实现目标接口
 * 3.实现InvocationHandler接口
 * 4.调用Proxy的newProxyInstance方法获取代理对象并强转为目标接口类型
 * 5.调用目标接口中的方法
 */
public class ApproverProxyBasedInterface implements InvocationHandler {
    //被代理对象
    private Object approver;

    public Object newProxyInstance(Object targetObject) {
        this.approver = targetObject;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(), this);
    }

    /**
     * 此处拦截接口中所有的方法，调用接口中的任何方法都会调用invoke方法
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String currentMethodName = method.getName();
        System.out.println("ApproverProxyBasedInterface-" + currentMethodName + "-before invoke");
        Object result = method.invoke(approver, args);
        System.out.println("ApproverProxyBasedInterface-" + currentMethodName + "-after invoke");
        return result;
    }
}
