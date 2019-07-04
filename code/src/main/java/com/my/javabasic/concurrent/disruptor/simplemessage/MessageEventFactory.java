package com.my.javabasic.concurrent.disruptor.simplemessage;

import com.lmax.disruptor.EventFactory;

public class MessageEventFactory implements EventFactory<MessageEvent> {
    @Override
    public MessageEvent newInstance() {
        return new MessageEvent();
    }
}
