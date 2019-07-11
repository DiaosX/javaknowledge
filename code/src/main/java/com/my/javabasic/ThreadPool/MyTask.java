package com.my.javabasic.ThreadPool;

import java.util.Date;

public class MyTask implements Runnable {
    @Override
    public void run() {
        String message = String.format("at=%s,ThreadId=%s", new Date(), Thread.currentThread().getId());
        System.out.println(message);
        try {
            //挂起三秒，模拟任务
            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}