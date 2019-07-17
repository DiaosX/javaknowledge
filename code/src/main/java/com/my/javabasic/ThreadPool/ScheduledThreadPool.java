package com.my.javabasic.threadpool;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 创建一个定长线程池，支持定时及周期性任务执行。
 */
public class ScheduledThreadPool {
    ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);

    public void startTask(int taskCount) {
        for (int i = 0; i < taskCount; i++) {
            MyTask task = new MyTask();
            //delay:从现在开始到执行的时间延时
            //每隔1秒执行一次
            //submit和execute()都是调用的schedule(),而且将延时时间设置为了0，
            // 所以想要实现延时操作，需要直接调用schedule()
            pool.schedule(task, 1, TimeUnit.SECONDS);
        }
    }

    public void shutdown() {
        pool.shutdown();
    }
}
