package com.my.javabasic.thread;


/**
 * 通过Runnable接口创建线程，不能有返回值
 */
public class NewThreadWithRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("通过Runnable类创建线程,我的Id是" + Thread.currentThread().getId() + "，我的名称为:" + Thread.currentThread().getName());
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
