package com.my.javabasic.designpattern.pipeline2;

public class MyHandler2 implements Handler {
    private final static String NAME = "MyHandler2";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void handle(HandlerContext ctx, Object msg) {
        System.out.println("MyHandler2");
        ctx.next(msg);
    }
}
