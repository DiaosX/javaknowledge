package com.my.javabasic.basicknowledge;

/**
 * 验证初始化顺序
 * 父类的静态代码块，子类的静态代码块，父类普通代码块，父类构造器，子类普通代码块，子类构造器，子类方法
 */
public class InstantiateOrderParent {
    public static int executeOrder = 0;

    static {
        executeOrder++;
        System.out.println(executeOrder + "-父类静态代码块");
    }

    {
        executeOrder++;
        System.out.println(executeOrder + "-父类普通代码块");
    }

    public InstantiateOrderParent() {
        executeOrder++;
        System.out.println(executeOrder + "-父类构造器");
    }

    public void print() {
        executeOrder++;
        System.out.println(executeOrder + "-父类print方法");
    }
}