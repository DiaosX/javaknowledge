package com.my.javabasic.designpattern.visitor.vistorhandle;

public class PreHandlerRequiredException extends RuntimeException {

    private int preHandlerIndex;

    public PreHandlerRequiredException(int index) {
        super();
        this.preHandlerIndex = index;
    }

    public int getPreHandlerIndex() {
        return preHandlerIndex;
    }
}
