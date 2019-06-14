package com.my.javabasic.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class NetworkCheckModule extends BaseModule {

    private final static String moduleName = "NetworkCheckModule";

    public NetworkCheckModule(CountDownLatch countDownLatch) {
        super(countDownLatch, moduleName);
    }

    @Override
    public void init() {
        try {
            //模拟操作
            sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
