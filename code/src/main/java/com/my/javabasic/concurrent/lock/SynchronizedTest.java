package com.my.javabasic.concurrent.lock;

/**
 * 关键字synchronized可以保证在同一时刻,只有一个线程可以执行某个方法或某个代码块
 * 同时synchronized可以保证一个线程的变化可见（可见性），即可以代替volatile
 * synchronized的三种应用方式
 * 1.普通同步方法（实例方法），锁是当前实例对象 ，进入同步代码前要获得当前实例的锁
 * 2.静态同步方法，锁是当前类的class对象 ，进入同步代码前要获得当前类对象的锁
 * 3.同步方法块，锁是括号里面的对象，对给定对象加锁，进入同步代码库前要获得给定对象的锁
 */
public class SynchronizedTest {

    public SynchronizedTest(Account account) {

    }

    private static Object syncLock = new Object();

    /**
     * 实例锁
     */
    public synchronized void setValue() {

    }

    /**
     * Class锁
     */
    public static synchronized void setValueStatic() {


    }

    public void setValueWithSyncronizedVar() {
        synchronized (syncLock) {


        }
    }
}
