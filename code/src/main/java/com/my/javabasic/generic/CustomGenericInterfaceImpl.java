package com.my.javabasic.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/*
泛型接口
 */
interface ICustomGenericInterface<E> {
    void print(E e);
}

public class CustomGenericInterfaceImpl implements ICustomGenericInterface<String> {
    @Override
    public void print(String s) {
        System.out.println(s);
    }

    public void printActualGenericType() {
        Type[] types = getClass().getGenericInterfaces();
        if (types != null && types.length > 0) {
            for (int i = 0; i < types.length; i++) {
                Type t = types[i];
                if (t instanceof ParameterizedType) {
                    Type[] p = ((ParameterizedType) t).getActualTypeArguments();
                    System.out.println(p[0]);
                }
            }
        }
    }
}