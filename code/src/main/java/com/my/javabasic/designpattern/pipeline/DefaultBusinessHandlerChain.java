package com.my.javabasic.designpattern.pipeline;

import java.util.List;

public class DefaultBusinessHandlerChain<C> extends BaseBusinessHandlerChain<BusinessHandler<C>> implements BusinessHandlerChain<C> {
    public DefaultBusinessHandlerChain(List<BusinessHandler<C>> handlers) {
        super(handlers);
    }

    @Override
    public void next(C context) {
        if (index < size) {
            handlerList.get(index++).handle(context, this);
        }
    }
}
