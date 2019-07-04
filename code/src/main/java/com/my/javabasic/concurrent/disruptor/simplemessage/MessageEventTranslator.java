package com.my.javabasic.concurrent.disruptor.simplemessage;

import com.lmax.disruptor.EventTranslatorOneArg;

public class MessageEventTranslator implements EventTranslatorOneArg<MessageEvent, String> {
    @Override
    public void translateTo(MessageEvent messageEvent, long l, String o2) {
        messageEvent.setMessage(o2);
    }
}
