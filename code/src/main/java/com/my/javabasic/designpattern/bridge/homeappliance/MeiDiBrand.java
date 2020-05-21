package com.my.javabasic.designpattern.bridge.homeappliance;

public class MeiDiBrand extends AbstractBrand {

    @Override
    public void run() {
        System.out.println("美的品牌");
        this.appliance.run();
    }
}
