package com.my.javabasic.concurrent.disruptor.logcollector;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;

public class LogInfoEventProducer {

    private RingBuffer<LogInfoEvent> ringBuffer;
    private EventTranslatorOneArg<LogInfoEvent, LogInfo> translator;

    public LogInfoEventProducer(RingBuffer<LogInfoEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
        this.translator = new LogInfoEventTranslator();
    }

    /**
     * 将接收到的消息输出到ringBuffer
     *
     * @param logInfo
     */
    public boolean produce(LogInfo logInfo) {
        try {
//            EventTranslatorOneArg<LogInfoEvent, LogInfo> translator = new LogInfoEventTranslator();
            ringBuffer.publishEvent(translator, logInfo);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
