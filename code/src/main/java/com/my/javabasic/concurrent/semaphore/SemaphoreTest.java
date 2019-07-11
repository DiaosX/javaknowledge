package com.my.javabasic.concurrent.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    //初始化许可证数量，公平模式
    Semaphore semaphore = new Semaphore(5, true);
//acquire():获取1个许可证
//---此线程会一直阻塞，直到获取这个许可证，或者被中断(抛出InterruptedException异常)。
//semaphore.acquire();

    //release()：释放1个许可证
//semaphore.release();

}
