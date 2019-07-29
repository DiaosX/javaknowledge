package com.my.javabasic.concurrent.lock.printcharbyordered;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class StringPrinterThreadContext {

    private int printLoop;

    public StringPrinterThreadContext(int printLoop) {
        this.printLoop = printLoop;

    }

    public int getPrintLoop() {
        return printLoop;
    }
    
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private int status = 1;

    private ReentrantLock lock = new ReentrantLock();

    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();


    public void printA(int order) {

        lock.lock();
        try {
            if (status != 1) {
                conditionA.await();
            }
            System.out.println(order + "-A");
            status = 2;
            conditionB.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();

        } finally {
            lock.unlock();
        }
    }

    public void printB(int order) {

        lock.lock();
        try {
            if (status != 2) {

                conditionB.await();
            }
            System.out.println(order + "-B");
            status = 3;
            conditionC.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();

        } finally {
            lock.unlock();
        }
    }

    public void printC(int order) {

        lock.lock();
        try {
            if (status != 3) {
                conditionC.await();
            }
            System.out.println(order + "-C");
            status = 1;
            conditionA.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();

        } finally {
            lock.unlock();
        }
    }
}
