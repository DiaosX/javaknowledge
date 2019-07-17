package com.my.javabasic.threadpool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

/**
 * ForkJoin线程池
 * 创建一个拥有多个任务队列的线程池，可以减少连接数，
 * 创建当前可用cpu数量的线程来并行执行，适用于大耗时的操作，可以并行来执行
 */
public class WorkStealingPool {
    private int taskCount;
    private CountDownLatch latch;
    private ForkJoinPool pool;

    public WorkStealingPool(int taskCount) {
        this.latch = new CountDownLatch(taskCount);
        //同时运行3个线程并行执行
        this.pool = (ForkJoinPool) Executors.newWorkStealingPool(100);
        this.taskCount = taskCount;
    }

    public void startTask(int taskCount) {
        for (int i = 0; i < taskCount; i++) {
            MyTask task = new MyTask(this.latch);
            pool.submit(task);
        }
        try {
            this.latch.await();
            System.out.println("所有任务全部完成.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
