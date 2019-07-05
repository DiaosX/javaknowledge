package com.my.javabasic.concurrent.disruptor.logcollector;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventTranslatorOneArg;

public class LogInfoEvent {
    /**
     * 定义事件工厂
     */
    public static final EventFactory<LogInfoEvent> EVENT_FACTORY = new EventFactory<LogInfoEvent>() {
        public LogInfoEvent newInstance() {
            return new LogInfoEvent();
        }
    };

    /**
     * 定义TRANSLATOR
     * EventTranslatorVararg<T></>:多个参数
     * EventTranslatorOneArg<T,A></>:一个参数
     * EventTranslatorTwoArg<T,A,B>:两个参数
     * EventTranslatorTwoArg<T,A,B,C>：三个参数
     */
    public static final EventTranslatorOneArg<LogInfoEvent, LogInfo> TRANSLATOR = new EventTranslatorOneArg<LogInfoEvent, LogInfo>() {
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
    };

    private String message;
    private String tag;
    private String createTime;
    private double useTime;
    private String appName;
    private String methodName;
    private String chainId;
    private String trackId;
    private String parentTrackId;
    private String input;
    private String output;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public double getUseTime() {
        return useTime;
    }

    public void setUseTime(double useTime) {
        this.useTime = useTime;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getChainId() {
        return chainId;
    }

    public void setChainId(String chainId) {
        this.chainId = chainId;
    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public String getParentTrackId() {
        return parentTrackId;
    }

    public void setParentTrackId(String parentTrackId) {
        this.parentTrackId = parentTrackId;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}
