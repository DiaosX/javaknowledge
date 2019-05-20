package com.my.javabasic.designpattern.decorate;

public class CupExtention implements ICup {

    protected ICup cup;

    public CupExtention(ICup cup) {
        this.cup = cup;
    }

    @Override
    public CupInfo getCup() {
        return null;
    }
}
