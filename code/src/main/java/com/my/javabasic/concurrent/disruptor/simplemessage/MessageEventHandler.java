package com.my.javabasic.concurrent.disruptor.simplemessage;

import com.lmax.disruptor.EventHandler;

public class MessageEventHandler implements EventHandler<MessageEvent> {
    @Override
    public void onEvent(MessageEvent event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("MessageEventHandler:" + event.getMessage());
    }
}
