package com.my.javabasic.concurrent.disruptor.simplemessage;

import com.lmax.disruptor.ExceptionHandler;

public class MessageExceptionHandler implements ExceptionHandler<MessageEvent> {
    @Override
    public void handleEventException(Throwable throwable, long l, MessageEvent messageEvent) {
        
    }

    @Override
    public void handleOnStartException(Throwable throwable) {

    }

    @Override
    public void handleOnShutdownException(Throwable throwable) {

    }
}
