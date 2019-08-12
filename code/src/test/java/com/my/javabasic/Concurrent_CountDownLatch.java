package com.my.javabasic;

import com.my.javabasic.concurrent.countdownlatch.CountDownLatchTest;
import com.my.javabasic.concurrent.countdownlatch.MyApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Concurrent_CountDownLatch {


    /**
     * 使用CountDownLatch协调线程步调一致
     */
    @Test
    public void countDownLatchTest() {
        final int awaitThreadCount = 5;
        CountDownLatch latch = new CountDownLatch(awaitThreadCount);
        for (int i = 0; i < awaitThreadCount; i++) {
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
