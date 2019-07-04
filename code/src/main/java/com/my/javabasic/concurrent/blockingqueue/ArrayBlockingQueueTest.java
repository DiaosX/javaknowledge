package com.my.javabasic.concurrent.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 有界阻塞队列
 */
public class ArrayBlockingQueueTest {

    private BlockingQueue<String> blockingDeque = new ArrayBlockingQueue<>(100);

    public void put(String message) throws InterruptedException {
        blockingDeque.put(message);
    }


}
