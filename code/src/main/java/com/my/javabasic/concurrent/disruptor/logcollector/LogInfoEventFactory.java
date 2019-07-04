package com.my.javabasic.concurrent.disruptor.logcollector;

import com.lmax.disruptor.EventFactory;

public class LogInfoEventFactory implements EventFactory<LogInfoEvent> {
    @Override
    public LogInfoEvent newInstance() {
        return new LogInfoEvent();
    }
}
