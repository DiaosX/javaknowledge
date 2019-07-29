package com.my.javabasic.concurrent.lock.synchronized1;

/*
wait()和notify()只能写在synchronized同步方法或同步块中。
wait()，线程休眠，等待唤醒，并释放对象锁（monitor）
notify()，随机唤醒一个正在等待对象锁的线程
notifyAll()，唤醒所有正在等待对象锁的线程
若没有正在等待对象锁的线程，则notify()和notifyAll()不起作用
一个线程被唤醒不代表立即获取了对象的monitor，只有等调用完notify()或者notifyAll()并退出synchronized块，释放对象锁后，其余线程才可获得锁执行
至于哪个线程接下来能够获取到对象的monitor就具体依赖于操作系统的调度了
 */

public class NumberProducer extends Thread {

    private final NumberHolder holer;

    public NumberProducer(NumberHolder holder) {
        this.holer = holder;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            synchronized (this.holer) {
                while (this.holer.getCurrentNumber() != 0) {
                    System.out.println("生产者：满了");
                    try {
                        //阻塞当前线程，释放锁
                        this.holer.wait();
                        System.out.println("NumberProducer获取锁成功，继续往下执行.");

                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                this.holer.setCurrentNumber(i);
                System.out.println("放入数字:" + i);
                this.holer.notify();//随机唤醒一个等待线程
            }
        }
    }
}
