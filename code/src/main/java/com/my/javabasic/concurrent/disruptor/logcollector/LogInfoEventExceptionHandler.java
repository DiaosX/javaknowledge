package com.my.javabasic.concurrent.disruptor.logcollector;

import com.lmax.disruptor.ExceptionHandler;

public class LogInfoEventExceptionHandler implements ExceptionHandler<LogInfoEvent> {
    @Override
    public void handleEventException(Throwable ex, long sequence, LogInfoEvent event) {
        ex.printStackTrace();
        System.out.println("消费事件时发生异常");
    }

    @Override
    public void handleOnStartException(Throwable ex) {
        ex.printStackTrace();
        System.out.println("Disruptor启动时失败");
    }

    @Override
    public void handleOnShutdownException(Throwable ex) {
        ex.printStackTrace();
        System.out.println("Disruptor停止时发生异常");
    }
}
