package com.my.javabasic.designpattern.state;

/**
 * 抽象状态
 */
public abstract class ICarState {

    private Car car;

    public ICarState(Car car) {
        this.car = car;
    }

    /**
     * 准备状态
     */
    public abstract void ready();

    /**
     * 运行状态
     */
    public abstract void running();

    /**
     * 停止状态
     */

    public abstract void stop();
}
