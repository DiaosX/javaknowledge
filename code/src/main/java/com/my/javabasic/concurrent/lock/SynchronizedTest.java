package com.my.javabasic.concurrent.lock;

/**
 * 关键字synchronized可以保证在同一时刻,只有一个线程可以执行某个方法或某个代码块
 * 同时synchronized可以保证一个线程的变化可见（可见性），即可以代替volatile
 * synchronized的三种应用方式
 * 1.普通同步方法（实例方法），锁是当前实例对象 ，进入同步代码前要获得当前实例的锁
 * 2.静态同步方法，锁是当前类的class对象 ，进入同步代码前要获得当前类对象的锁
 * 3.同步方法块，锁是括号里面的对象，对给定对象加锁，进入同步代码库前要获得给定对象的锁
 * <p>
 * synchronized属于可重入锁
 */

/*

如果要实现线程之间相互唤醒，synchronized结合object.wait(), object.notify()，object.notifyAll()实现
Thread.sleep()和object.wait()的区别：都释放CPU使用权，阻塞当前线程，但是object.wait()在释放CPU时同时释放锁
object.wait()的作用：释放对象所，并且阻塞当前线程，当前线程进入阻塞队列
object.notify()：唤醒对象等待集合中的随机一个线程，被唤醒的线程处于运行状态，此时改线程和其他线程一起竞争锁资源
规则上为什么wait(),notify(),notifyAll()需要放在synchronize的代码块中执行？
因为这三个方法都是释放锁的，如果没有synchronize先获取锁就调用会引起异常

 */
public class SynchronizedTest {

    public SynchronizedTest(Account account) {

    }

    private static Object syncLock = new Object();

    /**
     * 实例锁
     */
    public synchronized void setValue() {

    }

    /**
     * Class锁
     */
    public static synchronized void setValueStatic() {


    }

    public void setValueWithSyncronizedVar() {
        synchronized (syncLock) {


        }
    }
}
