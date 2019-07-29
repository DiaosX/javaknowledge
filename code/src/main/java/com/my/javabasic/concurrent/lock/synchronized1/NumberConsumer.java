package com.my.javabasic.concurrent.lock.synchronized1;

public class NumberConsumer extends Thread {

    private final NumberHolder holder;

    public NumberConsumer(NumberHolder holder) {
        this.holder = holder;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (this.holder) {
                while (this.holder.getCurrentNumber() == 0) {
                    System.out.println("消费者：空了");
                    try {
                        //休眠当前线程，等待唤醒，释放锁
                        this.holder.wait();
                        System.out.println("NumberConsumer获取锁成功，继续往下执行.");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("消费者取出数字:" + this.holder.getCurrentNumber());
                this.holder.setCurrentNumber(0);
                //随机唤醒一个正在等待锁的线程
                this.holder.notify();
            }
        }
    }
}
