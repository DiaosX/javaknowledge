package com.my.javabasic.concurrent.disruptor.logcollector;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LogManagerWithWorkPool {
    static LogInfoEventProducer producer;
    static ExecutorService executor;
    static Disruptor<LogInfoEvent> disruptor;
    //必须是2的N次方
    final static int ringBufferSize = 1024;

    static {
        executor = Executors.newCachedThreadPool();
        disruptor = new Disruptor<>(LogInfoEvent.EVENT_FACTORY, ringBufferSize, executor, ProducerType.SINGLE, new BlockingWaitStrategy());
        //启用workpool模式消费
        disruptor.handleEventsWithWorkerPool(new LogInfoEventWorkPoolHandler1(), new LogInfoEventWorkPoolHandler2());
        disruptor.handleExceptionsWith(new LogInfoEventExceptionHandler());
        RingBuffer<LogInfoEvent> ringBuffer = disruptor.start();
        producer = new LogInfoEventProducer(ringBuffer);
    }
    public static boolean save(LogInfo logInfo) {
        return producer.produce(logInfo);
    }
}
