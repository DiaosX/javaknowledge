package com.my.javabasic;


import com.my.javabasic.ThreadPool.CachedThreadPool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadPoolTest {

    @Test
    public void cachedThreadPoolTest() {
        int taskCount = 1000;
        CachedThreadPool pool = new CachedThreadPool();
        pool.startTask(taskCount);
        pool.showCurrentThreadCount();

        while (true) {
            if (pool.getCompletedTaskCount() == taskCount) {
                System.out.println("所有任务已经完成.");
                break;
            }
        }
        pool.shutdown();
    }
}
