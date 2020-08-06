package com.my.javabasic.designpattern.pipeline;

import java.util.List;

public abstract class BaseBusinessHandlerChain<H> {
    protected List<H> handlerList;
    protected int index = 0;
    protected int size;

    public BaseBusinessHandlerChain(List<H> handlers) {
        this.handlerList = handlers;
        this.size = handlers.size();
    }

    public BaseBusinessHandlerChain(List<H> handlers, int index) {
        this(handlers);
        this.index = index;
    }
}
