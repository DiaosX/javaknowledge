package com.my.javabasic;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.my.javabasic.concurrent.disruptor.logcollector.*;
import com.my.javabasic.concurrent.disruptor.simplemessage.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Concurrent_DisruptorTest {
    private static ExecutorService executor;

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
        doProduceLog(false);
        waitingForConsumeDone();
    }

    @Test
    public void testLogInfoProducer_Loop1000() {
        for (int i = 0; i < 1000; i++) {
            doProduceLog(false);
        }
        waitingForConsumeDone();
    }

    @Test
    public void testLogInfoProducerWithWorkPool_Loop1000() {

        for (int i = 0; i < 1000; i++) {
            doProduceLog(true);
        }
        waitingForConsumeDone();
    }

    @Test
    public void testLogInfoProducerWithWorkPool_Loop5() {

        for (int i = 0; i < 5000000; i++) {
            doProduceLog(true);
        }
        waitingForConsumeDone();
    }

    private void doProduceLog(boolean isWorkPoolMode) {
        LogInfo info = new LogInfo();
        info.setAppName("myApp");
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
        if (isWorkPoolMode) {
            LogManagerWithWorkPool.save(info);
        } else {
            LogManager.save(info);
        }
    }

    @Test
    public void testMultiProducer() {
        final int producerCount = 3;
        CountDownLatch latch = new CountDownLatch(producerCount);
        int batchSize = 50000;

        Disruptor<LogInfoEvent> disruptor = new Disruptor<>(
                LogInfoEvent.EVENT_FACTORY, 1024,
                Executors.newCachedThreadPool(),
                ProducerType.MULTI,
                new BlockingWaitStrategy());

        disruptor.handleEventsWith(new LogInfoEventHandler1(), new LogInfoEventHandler2());
        disruptor.handleExceptionsWith(new LogInfoEventExceptionHandler());
        RingBuffer<LogInfoEvent> ringBuffer = disruptor.start();
        LogInfoEventProducer producer = new LogInfoEventProducer(ringBuffer);
        for (int i = 0; i < producerCount; i++) {
            LogInfoEventProducer2 p1 = new LogInfoEventProducer2(latch, batchSize, producer);
            p1.start();
        }
        try {
            latch.await();
            System.out.println("发送完毕");
        } catch (Exception e) {
            e.printStackTrace();
        }
        waitingForConsumeDone();
    }

    private void waitingForConsumeDone() {
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
