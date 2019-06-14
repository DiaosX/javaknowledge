package com.my.javabasic;

import com.my.javabasic.concurrent.countdownlatch.CountDownLatchTest;
import com.my.javabasic.concurrent.countdownlatch.MyApplication;
import com.my.javabasic.concurrent.cyclicbarrier.CyclicBarrierTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConcurrentTest {
    @Test
    public void synchronizedCase() {

    }

    @Test
    public void cyclicBarrierTest() {
        int threadCount = 3;
        //CyclicBarrier cyclicBarrier = new CyclicBarrier(threadCount);
        //barrierAction:当最后一个线程到达屏障释放所有线程之前执行的操作，常用来更新状态或者合并结果
        CyclicBarrier cyclicBarrier = new CyclicBarrier(threadCount, new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("最后一个到达屏障的线程是-" + Thread.currentThread().getName());
                    Thread.sleep(7000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        for (int i = 0; i < threadCount; i++) {
            CyclicBarrierTest worker = new CyclicBarrierTest(cyclicBarrier);
            worker.start();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("打开的屏障数：" + cyclicBarrier.getParties() + ",等待屏障的线程数：" + cyclicBarrier.getNumberWaiting() + "创建工作线程:" + worker.getName());
        }
        for (int i = 0; i < 2; i++) {
            System.out.println("打开的屏障数：" + cyclicBarrier.getParties() + ",等待屏障的线程数：" + cyclicBarrier.getNumberWaiting());
        }
    }

    @Test
    public void countDownLatchTest() {
        final int awaitThreadCount = 5;
        CountDownLatch latch = new CountDownLatch(awaitThreadCount);
        for (int i = 0; i < 5; i++) {
            //int randNumber =rand.nextInt(MAX - MIN + 1) + MIN;
            Random random = new Random(i);
            //6s-10s
            int sleepMilliseconds = random.nextInt(10 * 1000 - 6 * 1000 + 1) + 6 * 1000;
            CountDownLatchTest countDownThread = new CountDownLatchTest(latch, sleepMilliseconds);
            countDownThread.setName("Thread" + i);
            countDownThread.start();
        }
        try {
            System.out.println("主线等待子线程完成任务");
            //等待所有子线程完成任务
            latch.await();
            System.out.println("主线程继续执行...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void useCountDownLatchInAppInitScenario() {
        MyApplication myApp = new MyApplication();
        //myApp.start();//使用线程执行子任务
        myApp.startWithThreadPool();//使用线程池执行子任务
        System.out.println("主线程将继续....");
    }
}
