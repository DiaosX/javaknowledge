package com.my.javabasic.designpattern.pipeline;

public interface HandlerPipeline<C> extends BusinessHandler<C> {
    void invoke(C ctx);
}
