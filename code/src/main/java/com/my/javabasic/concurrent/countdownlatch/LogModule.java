package com.my.javabasic.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * 日志模块
 */
public class LogModule extends BaseModule {

    private final static String moduleName = "LogModule";

    public LogModule(CountDownLatch countDownLatch) {
        super(countDownLatch, moduleName);
    }

    @Override
    public void init() {
        try {
            //模拟操作
            sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
