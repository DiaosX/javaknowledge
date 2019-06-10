package com.my.javabasic.designpattern.state;


/**
 * 准备状态
 */
public class ReadyState extends ICarState {

    public ReadyState(Car car) {
        super(car);
    }

    @Override
    public void ready() {
        System.out.println("已经准备好了.");
    }

    @Override
    public void running() {

        System.out.println("已经在运行了.");

    }

    @Override
    public void stop() {
        System.out.println("已经停止了.");
    }
}
