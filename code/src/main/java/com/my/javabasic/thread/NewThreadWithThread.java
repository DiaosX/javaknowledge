package com.my.javabasic.thread;


/**
 * 通过继承Thread类启动线程，默认线程为用户线程
 * 这种方式在外部不能捕获到线程内部的异常
 */
public class NewThreadWithThread extends Thread {
    private int sleepSeconds = 1000;

    public NewThreadWithThread() {
        //设置线程为守护线程，如果为false,则为用户线程，必须在start之前设置
        // 当所有的守护进程退出后JVM退出
        this.setDaemon(true);
    }

    public NewThreadWithThread(String name) {
        this();
        this.setName(name);
    }

    public NewThreadWithThread(String name, int sleepSeconds) {
        this(name);
        this.sleepSeconds = sleepSeconds;
    }


    @Override
    public void run() {
        System.out.println("通过Thread类创建线程,我的Id是" + this.getId() + "，我的名称为:" + this.getName());
        try {
            System.out.println(sleepSeconds);
            Thread.currentThread().sleep(sleepSeconds);
            System.out.println("当前线程继续.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
