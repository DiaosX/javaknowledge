package com.my.javabasic.concurrent.countdownlatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MyApplication {
    private final static int ModuleCount = 3;

    private List<BaseModule> modules;

    private CountDownLatch countDownLatch;

    public MyApplication() {
        this.modules = new ArrayList<>(ModuleCount);
        this.countDownLatch = new CountDownLatch(ModuleCount);
        this.setUp();
    }

    /**
     * 安装所有要初始化的模块
     */
    private void setUp() {
        NetworkCheckModule networkCheckModule = new NetworkCheckModule(this.countDownLatch);
        modules.add(networkCheckModule);

        IocInitializeModule iocInitializeModule = new IocInitializeModule(this.countDownLatch);
        modules.add(iocInitializeModule);

        LogModule logModule = new LogModule(this.countDownLatch);
        modules.add(logModule);
    }


    /**
     * 手工创建线程执行子任务
     */
    public void start() {
        try {
            for (int i = 0; i < modules.size(); i++) {
                modules.get(i).start();
            }
            System.out.println("在此等待子模块初始化完成");
            this.countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用线程池执行子任务
     */
    public void startWithThreadPool() {
        Executor executor = Executors.newFixedThreadPool(this.modules.size());
        for (final BaseModule module : this.modules) {
            executor.execute(module);
        }
        try {
            System.out.println("在此等待子模块初始化完成");
            this.countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
