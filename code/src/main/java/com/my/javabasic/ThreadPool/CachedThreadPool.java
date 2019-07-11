package com.my.javabasic.ThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
 */
public class CachedThreadPool {
    private ThreadPoolExecutor pool = (ThreadPoolExecutor) Executors.newCachedThreadPool();

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


