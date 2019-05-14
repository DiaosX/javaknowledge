package com.my.javabasic;


import com.my.javabasic.thread.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadTest {

    /*
    基本的线程类：
    Thread类，
    Runnable接口，
    Callable接口

     */

    /**
     * 使用Thread申明线程
     */
    @Test
    public void declareThreadWithThread() {
        NewThreadWithThread t = new NewThreadWithThread();
        //this.isAlive()判断线程是否运行
        showThreadState(t);
        org.junit.Assert.assertFalse("线程还没有启动", t.isAlive());
        t.start();
        try {
            //这里阻塞的是主线程，而非子线程
            NewThreadWithThread.sleep(100);
            Thread.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        org.junit.Assert.assertTrue("线程已经启动", t.isAlive());
        System.out.println("我是主线程,我的Id是：" + Thread.currentThread().getId());
    }

    /**
     * 使用Runnable申明线程
     */
    @Test
    public void declareThreadWithRunnable() {
        NewThreadWithRunnable runnable = new NewThreadWithRunnable();
        Thread t = new Thread(runnable);
        showThreadState(t);
        t.start();
        showThreadState(t);

        System.out.println("我是主线程,我的Id是：" + Thread.currentThread().getId());
    }

    /**
     * 使用Callable申明线程
     */
    @Test
    public void declareThreadWithCallable() {
        NewThreadWithCallable callable = new NewThreadWithCallable();
        FutureTask<String> promise = new FutureTask<>(callable);
        Thread t = new Thread(promise);
        showThreadState(t);
        t.start();
        showThreadState(t);
        try {
            if (promise.isDone()) {
                System.out.println("线程已经执行完成");
            } else {
                System.out.println("线程还没有执行完成");
            }
            String result = promise.get();
            System.out.println("线程返回的结果是:" + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("我是主线程,我的Id是：" + Thread.currentThread().getId());
    }

    private void showThreadState(Thread thread) {
        System.out.println("thread: id=" + thread.getId() + ",state=" + thread.getState().toString());
    }

    @Test
    public void joinThreads() {
        try {
            NewThreadWithThread t1 = new NewThreadWithThread("t1");
            NewThreadWithThread t2 = new NewThreadWithThread("t2", 2000);
            NewThreadWithThread t3 = new NewThreadWithThread("t3", 3000);
            t1.start();
            t2.start();
            t3.start();
            //当前线程等到子线程t1执行结束
            t1.join();
            //当前线程等到子线程t1执行结束
            //t2.join();
            //当前线程等到子线程t1执行结束
            //t3.join();
            System.out.println("主线程进入睡眠状态");
            //模拟等待子线程结束
            Thread.sleep(4000);
            System.out.println("主线程进入睡眠结束");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 网关原型
     */
    @Test
    public void gatewayPrototype() {
        GatewayRequestAcceptor acceptor = new GatewayRequestAcceptor();
        try {
            for (int i = 0; i < 300; i++) {
                GatewayRequestor requestor = new GatewayRequestor(acceptor);
                FutureTask<Boolean> promise = new FutureTask<>(requestor);
                Thread t = new Thread(promise);
                t.start();
            }
            System.out.println("当前请求队列中请求个数：" + acceptor.getCurrentRequestorCount());
            new GatewayRequestHandlerManager(acceptor);
            while (true) {
                GatewayRequestor requestor = new GatewayRequestor(acceptor);
                FutureTask<Boolean> promise = new FutureTask<>(requestor);
                Thread t = new Thread(promise);
                t.start();
                ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();
                System.out.println("当前激活的线程数：" + currentGroup.activeCount());
                Thread.sleep(10);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
