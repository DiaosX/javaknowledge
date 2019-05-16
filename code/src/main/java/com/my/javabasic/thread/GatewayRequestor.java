package com.my.javabasic.thread;

import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.FutureTask;

/**
 * 通过Callable接口申明线程，带有返回值,并且可以抛出异常
 * Callable 方式需要 FutureTask 实现类的支持。FutureTask 是  Future<E> 接口的实现类
 * FutureTask -> RunnableFuture<V> extends Runnable, Future<V>
 */
public class GatewayRequestor implements Callable<Boolean> {

    private GatewayRequestAcceptor acceptor;

    public GatewayRequestor(GatewayRequestAcceptor acceptor) {
        this.acceptor = acceptor;
    }

    @Override
    public Boolean call() throws Exception {
        System.out.println("通过Thread类创建线程,我的Id是" + Thread.currentThread().getId() + "，我的名称为:" + Thread.currentThread().getName());

        CompletableFuture<GatewayResponse> promise = new CompletableFuture();
        acceptor.accept(UUID.randomUUID().toString(), promise);


        Thread.currentThread().sleep(1000);

        return true;
    }

    public void start() {
        FutureTask<Boolean> promise = new FutureTask<>(this);
        Thread t = new Thread(promise);
        t.start();
    }
}

