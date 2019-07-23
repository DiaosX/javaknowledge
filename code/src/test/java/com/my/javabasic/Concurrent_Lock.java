package com.my.javabasic;

import com.my.javabasic.concurrent.lock.ReentrantLockTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Concurrent_Lock {

    @Test
    public void testReentrantLock_Fair() {
        int thread_count = 10;
        ReentrantLockTest lockTest = new ReentrantLockTest();
        for (int i = 0; i < thread_count; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "启动");
                    lockTest.acquireFairLock();
                }
            });
            t.start();
        }
        //公平模式下获取锁排队
    }

    @Test
    public void testReentrantLock_Unfair() {
        int thread_count = 50;
        ReentrantLockTest lockTest = new ReentrantLockTest();
        for (int i = 0; i < thread_count; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "启动");
                    lockTest.acquireUnfairLock();
                }
            });
            t.start();
        }
    }
}
