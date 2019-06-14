package com.my.javabasic.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * 基础模块
 */
public abstract class BaseModule extends Thread {
    private CountDownLatch countDownLatch;
    private String moduleName;
    private Boolean moduleReady = false;

    public BaseModule(CountDownLatch countDownLatch, String moduleName) {
        this.countDownLatch = countDownLatch;
        this.moduleName = moduleName;
    }

    @Override
    public void run() {
        super.run();
        try {
            this.startInit();//子模块初始化开始
            this.init();//子模块初始化
            this.endInit();//子模块初始化完成
            this.moduleReady = true;
        } catch (Exception e) {
            e.printStackTrace();
            this.moduleReady = false;
        } finally {
            this.countDownLatch.countDown();
        }
    }

    /**
     * 初始化操作
     */
    public abstract void init();

    protected void startInit() {
        System.out.println(moduleName + "初始化开始");
    }

    protected void endInit() {
        System.out.println(moduleName + "初始化完成");
    }
}
