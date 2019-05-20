package com.my.javabasic.designpattern.decorate;

public class RedColorCup extends CupExtention {

    public RedColorCup(ICup cup) {
        super(cup);
    }

    @Override
    public CupInfo getCup() {
        System.out.println("RedColorCup:给杯子涂上红色");
        CupInfo cup = this.cup.getCup();
        cup.setColor("红色杯子");
        return cup;
    }
}
