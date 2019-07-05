package com.my.javabasic.concurrent.disruptor.logcollector;

import com.alibaba.fastjson.JSON;
import com.lmax.disruptor.WorkHandler;

public class LogInfoEventWorkPoolHandler1 implements WorkHandler<LogInfoEvent> {

    private static final String HANDLER_NAME = "LogInfoEventWorkHandler1";

    private int handledCount = 0;

    @Override
    public void onEvent(LogInfoEvent event) throws Exception {
        handledCount++;
        //发送日志到本地flume
        System.out.println("handler=" + HANDLER_NAME + ",handledCount=" + handledCount);
        String logString = JSON.toJSONString(event);
        System.out.println(logString);
    }
}
