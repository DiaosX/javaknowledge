package com.my.javabasic.concurrent.disruptor.logcollector;

import java.util.concurrent.CountDownLatch;

public class LogInfoEventProducer2 extends Thread {

    private CountDownLatch latch;
    private int batchSize;
    private LogInfoEventProducer producer;

    public LogInfoEventProducer2(CountDownLatch latch, int batchSize, LogInfoEventProducer producer) {
        this.latch = latch;
        this.batchSize = batchSize;
        this.producer = producer;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < batchSize; i++) {
            this.producer.produce(makeLogInfo());
        }
        //通知主线程，子线程完成任务
        this.latch.countDown();
    }

    private LogInfo makeLogInfo() {
        LogInfo info = new LogInfo();
        info.setAppName("myapp");
        info.setMessage("Hello Disruptor");
        info.setInput("input");
        info.setOutput("output");
        info.setMethodName("method");
        info.setTag("tag");
        info.setUseTime(220.00);
        info.setChainId("chainId");
        info.setTrackId("TrackId");
        info.setParentTrackId("ParentTrackId");
        info.setCreateTime("createTime");
        return info;
    }
}
