package com.my.javabasic.concurrent.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * 循环屏障测试
 * CyclicBarrier是JDK1.5的java.util.concurrent并发包中提供的一个并发工具类
 * CyclicBarrier可以使一定数量的线程反复地在栅栏位置处汇集。
 * 当线程到达栅栏位置时将调用await方法，这个方法将阻塞直到所有线程都到达栅栏位置。如果所有线程都到达栅栏位置，那么栅栏将打开，此时所有的线程都将被释放，而栅栏将被重置以便下次使用。
 * CyclicBarrier内部使用了ReentrantLock和Condition两个类
 * 这个屏障之所以用循环修饰，是因为在所有的线程释放彼此之后，这个屏障是可以重新使用的
 */

/*
* 运用场景：
*1.做并发测试工具，等待所有的并发线程到达一个集合点，然后并发执行
*2.主任务等待子任务完成的场景。多线程分组计算
*
* */
public class CyclicBarrierTest extends Thread {

    private CyclicBarrier cyclicBarrier;

    public CyclicBarrierTest(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        super.run();
        try {
            System.out.println(Thread.currentThread().getName() + "开始等待其他线程,屏障是否破损：" + cyclicBarrier.isBroken());
            //当前线程到达屏障，阻塞当前线程，等待其他线程到达
            cyclicBarrier.await();

            System.out.println(Thread.currentThread().getName() + "开始执行");
            // 工作线程开始处理，这里用Thread.sleep()来模拟业务处理
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "执行完毕");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
