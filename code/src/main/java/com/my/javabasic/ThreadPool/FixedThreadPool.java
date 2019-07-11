package com.my.javabasic.ThreadPool;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
 */
public class FixedThreadPool {

    public void submitTask() {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 15; i = i + 5) {
            //pool.schedule(() -> System.out.println("我被执行了，当前时间" + new Date()), i, TimeUnit.SECONDS);
        }
        pool.shutdown();
    }
}
