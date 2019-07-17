package com.my.javabasic;


import com.my.javabasic.threadpool.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadPoolTest {

    /**
     * 可缓存线程池执行任务
     */
    @Test
    public void cachedThreadPoolTest() {
        int taskCount = 1000;
        CachedThreadPool pool = new CachedThreadPool();
        pool.startTask(taskCount);
        pool.showCurrentThreadCount();
        while (true) {
            if (pool.getCompletedTaskCount() == taskCount) {
                System.out.println("所有任务已经完成.");
                break;
            }
        }
        pool.shutdown();
    }

    /**
     * 固定个数线程池执行任务
     */
    @Test
    public void fixedThreadPoolTest() {
        int taskCount = 1000;
        FixedThreadPool pool = new FixedThreadPool();
        pool.startTask(taskCount);
        pool.showCurrentThreadCount();
        while (true) {
            if (pool.getCompletedTaskCount() == taskCount) {
                System.out.println("所有任务已经完成.");
                break;
            }
        }
        pool.shutdown();
    }

    /**
     * 单线程池执行任务
     */
    @Test
    public void singleThreadPoolTest() {
        int taskCount = 1000;
        SingleThreadExecutor pool = new SingleThreadExecutor(taskCount);
        pool.startTask();
        if (pool.getIsCompleted()) {
            System.out.println("所有任务已经完成.");
        }
        pool.shutdown();
    }

    /**
     * 调度线程池
     */
    @Test
    public void scheduledThreadPoolTest() {
        int taskCount = 1000;
        ScheduledThreadPool pool = new ScheduledThreadPool();
        pool.startTask(taskCount);

        while (true) {
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 测试并行执行任务
     */
    @Test
    public void workStealingPoolTest() {
        int taskCount = 1000;
        WorkStealingPool pool = new WorkStealingPool(taskCount);
        pool.startTask(taskCount);
        System.out.println("所有任务已完成.");
    }
}
