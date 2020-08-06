package com.my.javabasic.designpattern.pipeline2;

public class MyHandler1 implements Handler {
    private final static String NAME = "MyHandler1";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void handle(HandlerContext ctx, Object msg) {
        System.out.println("MyHandler1");
        ctx.next(msg);
    }
}
