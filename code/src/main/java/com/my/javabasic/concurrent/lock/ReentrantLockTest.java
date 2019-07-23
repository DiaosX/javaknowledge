package com.my.javabasic.concurrent.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁实现，基于AQS实现
 */
public class ReentrantLockTest {

    //公平锁
    private ReentrantLock fairLock = new ReentrantLock(true);
    //非公平锁，默认为非公平锁
    private ReentrantLock unfairLock = new ReentrantLock(false);


    /**
     * 公平的获取锁
     */
    public void acquireFairLock() {
        try {
            fairLock.lock();
            System.out.println(Thread.currentThread().getName() + "获得了锁");
        } finally {
            fairLock.unlock();
        }
    }

    /**
     * 非公平的获取锁
     */
    public void acquireUnfairLock() {
        try {
            unfairLock.lock();
            System.out.println(Thread.currentThread().getName() + "获得了锁");
        } finally {
            unfairLock.unlock();
        }
    }
}
