package com.my.javabasic.dynamicproxy;

import org.springframework.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

public class CrudInterceptorFilter implements CallbackFilter {

    public int accept(Method method) {
        if (!shouldIntercept(method)) {
            //返回空拦截器的顺序
            return 0;
        }
        String methodName = method.getName();
        if ("select".equals(methodName)) {
            //如果是select方法，则返回CrudSelectInterceptor拦截器的序号
            //表示用序号为1的回调处理器来处理select方法
            return 1;
        }
        if ("update".equals(methodName)) {
            //如果是update方法，则返回CrudUpdateInterceptor拦截器的序号
            //表示用序号为2的回调处理器来处理select方法
            return 2;
        } else {
            return 0;
        }
    }

    public boolean equals(Object target) {
        return true;
    }

    private boolean shouldIntercept(Method method) {
        //如果方法上面标注了Intercept注解则进行拦截
        return method.isAnnotationPresent(Intercept.class);
    }
}
