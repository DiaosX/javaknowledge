package com.my.javabasic;

import com.my.javabasic.concurrent.lock.synchronized1.NumberConsumer;
import com.my.javabasic.concurrent.lock.synchronized1.NumberHolder;
import com.my.javabasic.concurrent.lock.synchronized1.NumberProducer;
import com.my.javabasic.concurrent.lock.synchronized2.NumberPrinter;
import com.my.javabasic.concurrent.lock.synchronized2.StateHolder;
import com.my.javabasic.concurrent.lock.synchronized3.PrinterContext;
import com.my.javabasic.concurrent.lock.synchronized3.StringPrinterA;
import com.my.javabasic.concurrent.lock.synchronized3.StringPrinterB;
import com.my.javabasic.concurrent.lock.synchronized3.StringPrinterC;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Concurrent_Lock_Synchronized {

    @Test
    public void testReentrantLock_Fair() {

        NumberHolder holder = new NumberHolder();
        Thread p = new NumberProducer(holder);
        Thread c = new NumberConsumer(holder);

        p.start();
        c.start();

        try {
            Thread.sleep(5000);

        } catch (Exception e) {

            e.printStackTrace();
        }
        System.out.println("测试完成.");
    }

    @Test
    public void testPrintContentByOrdered() {
        StateHolder holder = new StateHolder(3, 10);
        NumberPrinter p1 = new NumberPrinter("A", 1, holder);
        NumberPrinter p2 = new NumberPrinter("B", 2, holder);
        NumberPrinter p3 = new NumberPrinter("C", 3, holder);
        p1.start();
        p2.start();
        p3.start();
    }


    @Test
    public void testPrintStringByOrdered() {
        PrinterContext holder = new PrinterContext();
        StringPrinterA p1 = new StringPrinterA(holder);
        StringPrinterB p2 = new StringPrinterB(holder);
        StringPrinterC p3 = new StringPrinterC(holder);
        p1.start();
        p2.start();
        p3.start();
    }
}
