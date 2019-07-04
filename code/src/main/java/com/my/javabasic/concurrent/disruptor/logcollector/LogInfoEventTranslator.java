package com.my.javabasic.concurrent.disruptor.logcollector;

import com.lmax.disruptor.EventTranslatorOneArg;

public class LogInfoEventTranslator implements EventTranslatorOneArg<LogInfoEvent, LogInfo> {
    @Override
    public void translateTo(LogInfoEvent event, long sequence, LogInfo logInfo) {

        event.setAppName(logInfo.getAppName());
        event.setChainId(logInfo.getChainId());
        event.setMessage(logInfo.getMessage());
        event.setTag(logInfo.getTag());
        event.setMethodName(logInfo.getMethodName());
        event.setTrackId(logInfo.getTrackId());
        event.setParentTrackId(logInfo.getParentTrackId());
        event.setCreateTime(logInfo.getCreateTime());
        event.setInput(logInfo.getInput());
        event.setOutput(logInfo.getOutput());
    }
}
