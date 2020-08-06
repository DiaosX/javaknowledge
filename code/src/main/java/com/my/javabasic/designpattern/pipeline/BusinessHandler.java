package com.my.javabasic.designpattern.pipeline;


public interface BusinessHandler<C> {
    /**
     * 处理业务逻辑
     *
     * @param ctx
     * @throws PipelineExecuteException
     */
    void handle(C ctx, BusinessHandlerChain<C> chain) throws PipelineExecuteException;
}
