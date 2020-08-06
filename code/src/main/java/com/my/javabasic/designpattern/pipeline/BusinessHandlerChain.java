package com.my.javabasic.designpattern.pipeline;

public interface BusinessHandlerChain<C> {

    void next(C context);
}
