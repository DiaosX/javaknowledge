package com.my.javabasic.designpattern.pipeline2;

public interface Handler {
    String getName();
    void handle(HandlerContext ctx, Object msg);
}
