package com.my.javabasic.ThreadPool;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
 */
public class SingleThreadExecutor {

    public  void submitTask()
    {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 15; i = i + 5) {
            pool.schedule(() -> System.out.println("我被执行了，当前时间" + new Date()), i, TimeUnit.SECONDS);
        }
        pool.shutdown();
    }
}
