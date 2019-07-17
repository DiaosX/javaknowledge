package com.my.javabasic.concurrent.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

/**
 * AtomicLong是作用是对长整形进行原子操作。
 */
public class AtomicLongType {

    private int threadCount = 10;

    AtomicLong atomicLong = new AtomicLong(0L);

    CountDownLatch latch = new CountDownLatch(threadCount);

    public long increase() {
        for (int i = 0; i < threadCount; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    atomicLong.getAndIncrement();
                    latch.countDown();
                }
            });
            t.start();
        }
        try {
            System.out.println(threadCount + "个线程启动完成，正在等待.");
            latch.await();
            System.out.println("所有增加都已经完成.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return atomicLong.get();
    }
}
