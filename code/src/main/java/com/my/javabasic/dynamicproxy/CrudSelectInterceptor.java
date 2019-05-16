package com.my.javabasic.dynamicproxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * select 方法拦截器
 */
public class CrudSelectInterceptor implements MethodInterceptor {

    private Object target;

    public CrudSelectInterceptor(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
            throws Throwable {
        System.out.println("CrudSelectInterceptor-intercept-执行方法前");
        Object result = method.invoke(this.target, objects);
        System.out.println("CrudSelectInterceptor-intercept-执行方法后");
        return result;
    }
}
