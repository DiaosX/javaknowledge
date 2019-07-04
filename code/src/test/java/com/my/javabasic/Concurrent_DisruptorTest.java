package com.my.javabasic;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.my.javabasic.concurrent.disruptor.logcollector.LogInfo;
import com.my.javabasic.concurrent.disruptor.logcollector.LogManager;
import com.my.javabasic.concurrent.disruptor.simplemessage.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Concurrent_DisruptorTest {
    static ExecutorService executor;

    @BeforeClass
    public static void init() {
        executor = Executors.newCachedThreadPool();
    }

    @AfterClass
    public static void clear() {
        executor.shutdown();
    }

    @Test
    public void testSimpleMessage() {
        String message = "Hello Disruptor!";
        int ringBufferSize = 1024;//必须是2的N次方

        Disruptor<MessageEvent> disruptor = new Disruptor<>(
                new MessageEventFactory(),
                ringBufferSize,
                executor,
                ProducerType.SINGLE,
                new BlockingWaitStrategy());
        disruptor.handleEventsWith(new MessageEventHandler());
        disruptor.handleExceptionsWith(new MessageExceptionHandler());
        RingBuffer<MessageEvent> ringBuffer = disruptor.start();
        MessageEventProducer producer = new MessageEventProducer(ringBuffer);
        producer.onData(message);
    }

    @Test
    public void testSimpleMessage_Loop5000() {
        String message = "Hello Disruptor!";
        int ringBufferSize = 1024;//必须是2的N次方
        Disruptor<MessageEvent> disruptor = new Disruptor<>(
                new MessageEventFactory(),
                ringBufferSize,
                executor,
                ProducerType.SINGLE,
                new BlockingWaitStrategy());
        disruptor.handleEventsWith(new MessageEventHandler());
        disruptor.handleExceptionsWith(new MessageExceptionHandler());
        RingBuffer<MessageEvent> ringBuffer = disruptor.start();
        MessageEventProducer producer = new MessageEventProducer(ringBuffer);
        for (int i = 0; i < 5000; i++) {
            producer.onData(message);
        }
    }

    @Test
    public void testLogInfoProducer() {
        doProduceLog();
        waitingForConsumeDone();
    }

    @Test
    public void testLogInfoProducer_Loop1000() {
        for (int i = 0; i < 1000; i++) {
            doProduceLog();
        }
        waitingForConsumeDone();
    }

    private void doProduceLog() {
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
        LogManager.save(info);
    }

    private void waitingForConsumeDone() {
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
