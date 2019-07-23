package com.my.javabasic.basicknowledge;

public class InstantiateOrder extends InstantiateOrderParent {
    static {
        InstantiateOrder.executeOrder++;
        System.out.println(InstantiateOrder.executeOrder + "-子类静态代码块");
    }

    static {
        InstantiateOrder.executeOrder++;
        System.out.println(InstantiateOrder.executeOrder + "-子类静态代码块");
    }

    //代码块
    {
        InstantiateOrder.executeOrder++;
        System.out.println(InstantiateOrder.executeOrder + "-子类普通代码块");
    }

    {
        InstantiateOrder.executeOrder++;
        System.out.println(InstantiateOrder.executeOrder + "-子类普通代码块");
    }

    public InstantiateOrder() {
        InstantiateOrder.executeOrder++;
        System.out.println(InstantiateOrder.executeOrder + "-子类构造器");
    }

    @Override
    public void print() {
        InstantiateOrder.executeOrder++;
        System.out.println(executeOrder + "-子类print方法");
    }
}
