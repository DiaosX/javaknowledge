package com.my.javabasic.concurrent.lock.synchronized3;

public class StringPrinterC extends Thread {
    private final PrinterContext lock;

    public StringPrinterC(PrinterContext lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            synchronized (lock) {
                //如果当前是线程3
                while (lock.getStatus() != 3) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                }
                System.out.println(i + "-C");
                lock.setStatus(1);
                lock.notifyAll();
            }
        }
    }
}
