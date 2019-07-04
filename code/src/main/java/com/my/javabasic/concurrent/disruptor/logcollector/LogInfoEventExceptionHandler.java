package com.my.javabasic.concurrent.disruptor.logcollector;

import com.lmax.disruptor.ExceptionHandler;

public class LogInfoEventExceptionHandler implements ExceptionHandler<LogInfoEvent> {
    @Override
    public void handleEventException(Throwable ex, long sequence, LogInfoEvent event) {
        ex.printStackTrace();
    }

    @Override
    public void handleOnStartException(Throwable ex) {
        ex.printStackTrace();
    }

    @Override
    public void handleOnShutdownException(Throwable ex) {
        ex.printStackTrace();
    }
}
