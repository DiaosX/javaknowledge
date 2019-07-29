package com.my.javabasic.concurrent.lock.printcharbyordered;

public class StringPrinterThreadB extends Thread {
    private StringPrinterThreadContext context;

    public StringPrinterThreadB(StringPrinterThreadContext context) {
        this.context = context;

    }

    @Override
    public void run() {
        for (int i = 0; i < context.getPrintLoop(); i++) {
            context.printB(i);
        }
    }
}
