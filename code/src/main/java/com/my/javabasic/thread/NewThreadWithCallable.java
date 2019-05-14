package com.my.javabasic.thread;

import java.util.concurrent.Callable;

/**
 * 通过Callable接口申明线程，带有返回值,并且可以抛出异常
 * Callable 方式需要 FutureTask 实现类的支持。FutureTask 是  Future<E> 接口的实现类
 * FutureTask -> RunnableFuture<V> extends Runnable, Future<V>
 */
public class NewThreadWithCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("通过Thread类创建线程,我的Id是" + Thread.currentThread().getId() + "，我的名称为:" + Thread.currentThread().getName());
        Thread.currentThread().sleep(1000);
        return "NewThreadWithCallable";
    }
}

