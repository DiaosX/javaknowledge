package com.my.javabasic.concurrent.lock.printcharbyordered;

public class StringPrinterThreadC extends Thread {

    private StringPrinterThreadContext context;

    public StringPrinterThreadC(StringPrinterThreadContext context) {
        this.context = context;

    }

    @Override
    public void run() {

        for (int i = 0; i < context.getPrintLoop(); i++) {
            context.printC(i);
        }

    }
}
