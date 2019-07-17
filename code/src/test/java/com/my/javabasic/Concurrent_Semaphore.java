package com.my.javabasic;


import com.my.javabasic.concurrent.semaphore.SemaphoreTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Concurrent_Semaphore {

    @Test
    public void testSemaphore() {

        SemaphoreTest test = new SemaphoreTest();
        test.readData();

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
