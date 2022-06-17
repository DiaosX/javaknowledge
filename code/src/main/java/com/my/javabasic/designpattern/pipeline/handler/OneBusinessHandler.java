package com.my.javabasic.designpattern.pipeline.handler;

import com.my.javabasic.designpattern.pipeline.BusinessHandler;
import com.my.javabasic.designpattern.pipeline.BusinessHandlerChain;
import com.my.javabasic.designpattern.pipeline.HandlerContext;
import com.my.javabasic.designpattern.pipeline.PipelineExecuteException;

public class OneBusinessHandler implements BusinessHandler<HandlerContext> {
    @Override
    public void handle(HandlerContext ctx, BusinessHandlerChain<HandlerContext> chain) throws PipelineExecuteException {
        System.out.println("OneBusinessHandler");
        chain.next(ctx);
    }
}