package com.my.javabasic.generic;

import java.util.List;

public class GenericTypeMethod {

    public static <T> void showType(T type) {
        if (type != null) {
            System.out.println(type.getClass());
        } else {
            System.out.println("class is null.");
        }
    }

    /*
    泛型上限约束
     */
    public static <T extends Number> void add(T p1, T p2) {
        if (p1 != null && p2 != null) {
            Integer result = (Integer) p1 + (Integer) p2;
            System.out.println("sum=" + result);
        } else System.out.println("sum=0");
    }

}
