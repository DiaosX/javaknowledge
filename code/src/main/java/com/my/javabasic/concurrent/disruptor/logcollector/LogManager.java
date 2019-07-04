package com.my.javabasic.concurrent.disruptor.logcollector;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LogManager {
    static LogInfoEventProducer producer;
    static ExecutorService executor;
    static Disruptor<LogInfoEvent> disruptor;
    //必须是2的N次方
    final static int ringBufferSize = 1024;

    static {
        executor = Executors.newCachedThreadPool();
        disruptor = new Disruptor<>(new LogInfoEventFactory(), ringBufferSize, executor, ProducerType.SINGLE, new BlockingWaitStrategy());
        disruptor.handleEventsWith(new LogInfoEventHandler());
        disruptor.handleExceptionsWith(new LogInfoEventExceptionHandler());
        RingBuffer<LogInfoEvent> ringBuffer = disruptor.start();
        producer = new LogInfoEventProducer(ringBuffer);
    }

    public static boolean save(LogInfo logInfo) {
        return producer.produce(logInfo);
    }
}
