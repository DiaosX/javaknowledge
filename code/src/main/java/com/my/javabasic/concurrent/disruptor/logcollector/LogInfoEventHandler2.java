package com.my.javabasic.concurrent.disruptor.logcollector;

import com.alibaba.fastjson.JSON;
import com.lmax.disruptor.EventHandler;

public class LogInfoEventHandler2 implements EventHandler<LogInfoEvent> {

    private static final String HANDLER_NAME = "LogInfoEventHandler2";
    private int handledCount = 0;

    @Override
    public void onEvent(LogInfoEvent event, long sequence, boolean endOfBatch) throws Exception {
        handledCount++;
        //发送日志到本地flume
        System.out.println("handler=" + HANDLER_NAME + ",sequence=" + sequence + ",endOfBatch=" + endOfBatch + ",handledCount=" + handledCount);
        String logString = JSON.toJSONString(event);
        System.out.println(logString);
    }
}
