package com.my.javabasic.concurrent.disruptor.logcollector;


import com.alibaba.fastjson.JSON;
import com.lmax.disruptor.EventHandler;

public class LogInfoEventHandler implements EventHandler<LogInfoEvent> {
    @Override
    public void onEvent(LogInfoEvent event, long sequence, boolean endOfBatch) throws Exception {
        //发送日志到本地flume
        System.out.println("sequence=" + sequence + ",endOfBatch=" + endOfBatch);
        String logString = JSON.toJSONString(event);
        System.out.println(logString);
    }
}
