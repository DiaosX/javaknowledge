package com.my.javabasic.concurrent.lock.printcharbyordered;

public class StringPrinterThreadA extends Thread {

    private StringPrinterThreadContext context;

    public StringPrinterThreadA(StringPrinterThreadContext context) {
        this.context = context;

    }

    @Override
    public void run() {

        for (int i = 0; i < context.getPrintLoop(); i++) {
            context.printA(i);
        }

    }
}
