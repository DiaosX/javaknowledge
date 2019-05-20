package com.my.javabasic.designpattern.decorate;

public class Cup implements ICup {

    public CupInfo getCup() {
        System.out.println("Cup:具体的杯子");
        CupInfo cup = new CupInfo();
        cup.setPrice(100);
        return cup;
    }
}
