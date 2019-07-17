package com.my.javabasic.concurrent.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/*
Semaphore是用来控制访问共享资源的线程数的个数，他通过协调各个线程，以保证合理的使用共享资源。

运用场景：流量控制，

NonfairSync:非公平

*/

public class SemaphoreTest {
    final static int thread_count = 20;
    static ExecutorService pool = Executors.newFixedThreadPool(thread_count);

    //初始化许可证数量，公平模式
    //最多5个线程访问共享资源
    static Semaphore semaphore = new Semaphore(5);
//acquire():获取1个许可证
//---此线程会一直阻塞，直到获取这个许可证，或者被中断(抛出InterruptedException异常)。
//semaphore.acquire();
//release()：释放1个许可证
//semaphore.release();

    public void readData() {
        for (int i = 0; i < thread_count; i++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        if (semaphore.availablePermits() > 0) {
                            semaphore.acquire();
                        } else {
                            System.out.println("没有可用的资源了");
                        }
                        System.out.println("读取数据");
                        Thread.sleep(1000);
                        semaphore.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
