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

    /* handleEventsWith(EventHandler ..handlers):广播，一个消息被多个消费者消费
    disruptor.handleEventsWithWorkerPool(WorkHandler<T>... workHandlers)：多个消费者消费同一个队列里的消息，不会重复消费
    */
    static {
        executor = Executors.newCachedThreadPool();
        disruptor = new Disruptor<>(LogInfoEvent.EVENT_FACTORY, ringBufferSize, executor, ProducerType.SINGLE, new BlockingWaitStrategy());
        disruptor.handleEventsWith(new LogInfoEventHandler1());
        disruptor.handleEventsWith(new LogInfoEventHandler2());
        disruptor.handleExceptionsWith(new LogInfoEventExceptionHandler());
        RingBuffer<LogInfoEvent> ringBuffer = disruptor.start();
        producer = new LogInfoEventProducer(ringBuffer);
    }

    public static boolean save(LogInfo logInfo) {
        return producer.produce(logInfo);
    }

    public static void stop() {
        disruptor.shutdown();
    }
}
