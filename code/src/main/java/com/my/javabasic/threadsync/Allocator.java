package com.my.javabasic.threadsync;

import java.util.ArrayList;
import java.util.List;

//此类必须单例
//等待-通知 机制获取、释放锁
public class Allocator {

    private List<Object> container;

    public Allocator() {
        container = new ArrayList<>();
    }

    public synchronized void apply(Object from, Object to) {
        Thread t=Thread.currentThread();
        System.out.println("["+t.getName()+"]我排队进来了");

        while (container.contains(from) || container.contains(to)) {
            try {

                System.out.println("["+t.getName()+"]Oh No，我没拿到锁");

                wait();//此处会释放锁，然后阻塞当前线程,待收到通知，继续进行while循环，获取锁

            } catch (Exception e) {
                System.out.println(e);
            }

        }

        container.add(from);
        container.add(to);
        System.out.println("["+t.getName()+"]Oh Yes，我拿到锁了");
    }


    public synchronized void free(Object from, Object to) {
        container.remove(from);
        container.remove(to);

        notifyAll();

        Thread t=Thread.currentThread();
        System.out.println("["+t.getName()+"]释放锁");
    }
}
