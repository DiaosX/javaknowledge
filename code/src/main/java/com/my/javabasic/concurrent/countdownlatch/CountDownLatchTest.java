package com.my.javabasic.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * 等待其他线程完成任务
 * Java1.5之后引入的Java并发工具类，JDK 5+里面闭锁的一个实现
 */

/*
* 解释CountDownLatch的概念？
* --是一个并发同步工具类，能够使一个或多个线程等待其他线程完成各自的工作后再执行
*
* CountDownLatch和CyclicBarrier之间的区别？
* --CountDownLatch不可重用而CyclicBarrier可以重用（reset方法）
* --CountDownLatch是等待其他任务完成，而CyclicBarrier是等待其他线程
*
* 给出CountDownLatch的一些示例用法？
* --框架启动时等待其他服务线程已经完成所有服务
* --开启多个线程分块下载一个大文件，每个线程只下载固定的一截，最后由另外一个线程来拼接所有的分段。
* --确保一个计算不会执行，直到所需要的资源被初始化
*
* CountDownLatch类有哪些主要方法？
* --countDown():递减计数器值
* --await():主线程等待计数器值变为0
* --getCount():得到当前的计数
*
* */
public class CountDownLatchTest extends Thread {
    private CountDownLatch countDownLatch;
    private int sleepMilliseconds;

    public CountDownLatchTest(CountDownLatch countDownLatch, int sleepMilliseconds) {
        this.countDownLatch = countDownLatch;
        this.sleepMilliseconds = sleepMilliseconds;
    }

    @Override
    public void run() {
        super.run();
        try {
            System.out.println("子任务-" + getName() + "开始执行...,将持续耗时:" + this.sleepMilliseconds + "毫秒");
            sleep(this.sleepMilliseconds);
            this.countDownLatch.countDown();
            System.out.println("子任务-" + getName() + "完成,计数器当前值：" + this.countDownLatch.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
