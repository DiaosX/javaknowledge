package com.my.javabasic.ThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
 */
public class FixedThreadPool {

    private ThreadPoolExecutor pool = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

    public void startTask(int taskCount) {
        for (int i = 0; i < taskCount; i++) {
            MyTask task = new MyTask();
            pool.submit(task);
        }
    }

    public void showCurrentThreadCount() {
        int count = pool.getActiveCount();
        System.out.println("当前活动线程数：" + count);
    }

    public void shutdown() {
        pool.shutdown();
    }

    public long getCompletedTaskCount() {
        return pool.getCompletedTaskCount();
    }
}
