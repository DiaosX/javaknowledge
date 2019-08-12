package com.my.javabasic;

import com.my.javabasic.concurrent.cyclicbarrier.CyclicBarrierTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CyclicBarrier;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Concurrent_CyclicBarrier {
    @Test
    public void cyclicBarrierTest() {
        int threadCount = 3;
        //CyclicBarrier cyclicBarrier = new CyclicBarrier(threadCount);
        //barrierAction:当最后一个线程到达屏障释放所有线程之前执行的操作，常用来更新状态或者合并结果
        CyclicBarrier cyclicBarrier = new CyclicBarrier(threadCount, new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("最后一个到达屏障的线程是-" + Thread.currentThread().getName());
                    Thread.sleep(7000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        for (int i = 0; i < threadCount; i++) {
            CyclicBarrierTest worker = new CyclicBarrierTest(cyclicBarrier);
            worker.start();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("打开的屏障数：" + cyclicBarrier.getParties() + ",等待屏障的线程数：" + cyclicBarrier.getNumberWaiting() + "创建工作线程:" + worker.getName());
        }
        for (int i = 0; i < 2; i++) {
            System.out.println("打开的屏障数：" + cyclicBarrier.getParties() + ",等待屏障的线程数：" + cyclicBarrier.getNumberWaiting());
        }
    }
}
