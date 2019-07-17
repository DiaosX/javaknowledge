package com.my.javabasic.threadpool;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class MyTask implements Runnable {
    private CountDownLatch latch;

    public MyTask() {

    }

    public MyTask(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            String message = String.format("at=%s,ThreadId=%s", new Date(), Thread.currentThread().getId());
            System.out.println(message);
            //挂起2秒，模拟任务执行耗时
            Thread.sleep(2000);
            if (this.latch != null) {
                this.latch.countDown();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}