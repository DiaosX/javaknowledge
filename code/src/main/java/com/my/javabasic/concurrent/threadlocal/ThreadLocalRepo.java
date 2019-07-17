package com.my.javabasic.concurrent.threadlocal;

import java.util.concurrent.CyclicBarrier;

/*
 ThreadLocal 是一个数据结构，可以保存Key:Value键值对，但是一个ThreadLocal只能保存一个
 并且各个线程的数据互不相干

 ThreadLocal可能导致内存泄漏:

 ThreadLocal类并不是用来解决多线程环境下的共享变量问题，而是用来提供线程内部的共享变量，在多线程环境下，
 可以保证各个线程之间的变量互相隔离、相互独立。
 */
public class ThreadLocalRepo extends Thread {

    private CyclicBarrier barrier;

    public ThreadLocalRepo(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    static ThreadLocal<String> localName = new ThreadLocal();

    @Override
    public void run() {
        super.run();
        localName.set("local" + Thread.currentThread().getId());
        try {
            this.barrier.await();
            System.out.println("读取到的值为:" + localName.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
