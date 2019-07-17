package com.my.javabasic;

import com.my.javabasic.concurrent.atomic.AtomicLongType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Concurrent_Atomic {

    @Test
    public void testAtomicLong() {
        AtomicLongType type = new AtomicLongType();
        long result = type.increase();
        System.out.println("结果为:" + result);
        System.out.println("执行完成.");
    }
}
