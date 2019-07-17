package com.my.javabasic;


import com.my.javabasic.concurrent.threadlocal.ThreadLocalRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CyclicBarrier;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Concurrent_ThreadLocal {

    @Test
    public void testThreadLocal() {
        int threadCount = 2;
        CyclicBarrier barrier = new CyclicBarrier(threadCount);
        for (int i = 0; i < threadCount; i++) {
            Thread t = new ThreadLocalRepo(barrier);
            t.start();
        }
        System.out.println("测试完成.");
    }
}
