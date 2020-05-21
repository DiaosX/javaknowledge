package com.my.javabasic.designpattern.bridge.homeappliance;

public class FridgeAppliance implements Appliance {
    @Override
    public void run() {
        System.out.println("冰箱运行");
    }
}
