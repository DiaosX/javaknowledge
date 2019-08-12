package com.my.javabasic;

import com.my.javabasic.concurrent.lock.ReentrantLock1.VerifyReentrantLockFairness;
import com.my.javabasic.concurrent.lock.printcharbyordered.StringPrinterThreadA;
import com.my.javabasic.concurrent.lock.printcharbyordered.StringPrinterThreadB;
import com.my.javabasic.concurrent.lock.printcharbyordered.StringPrinterThreadC;
import com.my.javabasic.concurrent.lock.printcharbyordered.StringPrinterThreadContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Concurrent_Lock_ReentrantLock {

    /**
     * ReentrantLock公平模式
     */
    @Test
    public void testReentrantLock_Fair() {
        int thread_count = 10;
        VerifyReentrantLockFairness lockTest = new VerifyReentrantLockFairness();
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

    /**
     * ReentrantLock的非公平模式
     */

    @Test
    public void testReentrantLock_Unfair() {
        int thread_count = 50;
        VerifyReentrantLockFairness lockTest = new VerifyReentrantLockFairness();
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

    /**
     * 测试ReentrantLock的条件
     */

    @Test
    public void testReentrantLockCondition() {

        StringPrinterThreadContext context = new StringPrinterThreadContext(10);

        StringPrinterThreadA threadA = new StringPrinterThreadA(context);
        StringPrinterThreadB threadB = new StringPrinterThreadB(context);
        StringPrinterThreadC threadC = new StringPrinterThreadC(context);
        threadA.start();
        threadB.start();
        threadC.start();
    }
}
