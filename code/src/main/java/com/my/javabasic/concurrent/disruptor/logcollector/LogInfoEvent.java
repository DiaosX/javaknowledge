package com.my.javabasic.concurrent.disruptor.logcollector;

public class LogInfoEvent {
    private String message;

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
}
