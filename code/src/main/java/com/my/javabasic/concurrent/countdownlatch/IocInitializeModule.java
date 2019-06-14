package com.my.javabasic.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * IOC容器初始化模块
 */
public class IocInitializeModule extends BaseModule {
    private final static String moduleName = "IocInitializeModule";

    public IocInitializeModule(CountDownLatch countDownLatch) {
        super(countDownLatch, moduleName);
    }

    @Override
    public void init() {
        try {
            //模拟操作
            sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
