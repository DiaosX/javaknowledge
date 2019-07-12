package com.my.javabasic.ThreadPool;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;

/**
 * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
 * 串行执行所有任务
 * 如果这个唯一的线程因为异常结束，那么会有一个新的线程来替代它。
 * 此线程池保证所有任务的执行顺序按照任务的提交顺序执行
 * 内部使用LinkedBlockingQueue作为阻塞队列。
 * 与newFixedThreadPool(1)不同的是不能重新配置加入线程，使用FinalizableDelegatedExecutorService进行包装
 */
public class SingleThreadExecutor {
    private AbstractExecutorService pool;
    private CountDownLatch latch;
    private int taskCount = 0;
    private boolean isCompleted = false;

    public SingleThreadExecutor(int taskCount) {
        this.taskCount = taskCount;
        this.latch = new CountDownLatch(taskCount);
        this.pool = (AbstractExecutorService) Executors.newSingleThreadExecutor();
    }

    public void startTask() {
        for (int i = 0; i < this.taskCount; i++) {
            MyTask task = new MyTask(this.latch);
            Thread.currentThread().setName("Thread i = " + i);
            pool.submit(task);
        }
        try {
            this.latch.await();
            this.isCompleted = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * shutdown后不能再往线程池中添加任务，否则抛出RejectedExecutionException异常
     */
    public void shutdown() {
        pool.shutdown();
    }

    public boolean getIsCompleted() {
        return this.isCompleted;
    }
}
