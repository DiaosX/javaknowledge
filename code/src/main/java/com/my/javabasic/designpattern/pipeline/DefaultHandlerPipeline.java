package com.my.javabasic.designpattern.pipeline;

public class DefaultHandlerPipeline<C> extends BaseHandlerPipeline<BusinessHandler<C>> implements HandlerPipeline<C> {
    @Override
    public void invoke(C ctx) {
        BusinessHandlerChain<C> chain = new DefaultBusinessHandlerChain<>(getValves());
        chain.next(ctx);
    }

    @Override
    public void handle(C ctx, BusinessHandlerChain<C> chain) throws PipelineExecuteException {
        invoke(ctx);
        chain.next(ctx);
    }
}
