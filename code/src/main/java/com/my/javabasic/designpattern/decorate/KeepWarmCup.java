package com.my.javabasic.designpattern.decorate;

public class KeepWarmCup extends CupExtention {

    public KeepWarmCup(ICup cup) {
        super(cup);
    }

    @Override
    public CupInfo getCup() {
        System.out.println("KeepWarmCup:增加保温功能");
        CupInfo cup = this.cup.getCup();
        cup.setKeepWarm(true);
        return cup;
    }
}
