package com.my.javabasic.dynamicproxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Update 方法拦截器
 */
public class CrudUpdateInterceptor implements MethodInterceptor {

    private Object target;

    public CrudUpdateInterceptor(Object target) {
        this.target = target;

    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
            throws Throwable {
        System.out.println("CrudUpdateInterceptor-intercept-执行方法前");
        Object result = method.invoke(this.target, objects);
        System.out.println("CrudUpdateInterceptor-intercept-执行方法后");
        return result;
    }
}
