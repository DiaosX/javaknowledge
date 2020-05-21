package com.my.javabasic.designpattern.bridge.homeappliance;

public class WashingAppliance implements Appliance {
    @Override
    public void run() {
        System.out.println("洗衣机运行");
    }
}
