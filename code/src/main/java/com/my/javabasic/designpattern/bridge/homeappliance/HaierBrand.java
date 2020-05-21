package com.my.javabasic.designpattern.bridge.homeappliance;

public class HaierBrand extends AbstractBrand {

    @Override
    public void run() {
        System.out.println("海尔品牌");
        this.appliance.run();
    }
}
