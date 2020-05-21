package com.my.javabasic.designpattern.bridge.homeappliance;

/**
 * 品牌
 */
public abstract class AbstractBrand {

    protected Appliance appliance;

    public void setAppliance(Appliance appliance) {
        this.appliance = appliance;

    }

    public abstract void run();
}
