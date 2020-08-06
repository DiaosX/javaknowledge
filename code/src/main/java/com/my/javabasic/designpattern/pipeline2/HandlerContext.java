package com.my.javabasic.designpattern.pipeline2;

public class HandlerContext {
    private HandlerContext next;
    private final Handler handler;

    public HandlerContext(Handler handler) {
        this.handler = handler;
    }

    public Handler getHandler() {
        return this.handler;
    }

    public void setNext(HandlerContext ctx) {
        this.next = ctx;
    }

    public void invokeNext(Object msg) {
        if (next != null) {
            this.handler.handle(next, msg);
        }
    }

    public void next(Object msg) {
        invokeNext(msg);
    }
}
