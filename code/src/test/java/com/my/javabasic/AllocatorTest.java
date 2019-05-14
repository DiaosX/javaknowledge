package com.my.javabasic;

import com.my.javabasic.threadsync.Allocator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;
import java.util.concurrent.ExecutionException;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAsync
public class AllocatorTest {


    @Test
    public void ApplyAndFreeTest() throws ExecutionException, InterruptedException {

        Account from = new Account(1, "from");
        Account to = new Account(2, "to");
        Allocator allocator = new Allocator();

        for (int i = 0; i < 10; i++) {
            new ThreadRunable("Thread" + i, allocator, from, to).Start();
        }

        Thread.sleep(100000);
    }
}

class ThreadRunable implements Runnable {
    Thread t;
    String threadName;
    Allocator allocator;
    private Account from, to;


    public ThreadRunable(String threadName, Allocator allocator, Account from, Account to) {
        this.threadName = threadName;
        this.allocator = allocator;
        this.from = from;
        this.to = to;
        System.out.println("Creating " + threadName);
    }

    @Override
    public void run() {
        System.out.println("Running " + threadName);

        allocator.apply(from, to);
        from.Reduce(100);
        to.Add(100);
        try {
            Thread.sleep(new Random(1000).nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        allocator.free(from, to);
    }

    public void Start() {
        if (t == null)
            t = new Thread(this, threadName);

        t.start();
    }
}

class Account {

    private int id;
    private String name;
    private int balance = 10000;

    Account(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void Reduce(int num) {
        this.balance = this.balance - num;
        System.out.println("账户" + name + "减少" + num + "，余额" + this.balance);
    }

    public void Add(int num) {
        this.balance = this.balance + num;
        System.out.println("账户" + name + "加" + num + "，余额" + this.balance);
    }
}
