package com.my.javabasic.concurrent.lock.synchronized2;

public class StateHolder {

    private volatile int Order = 1;
    private final int printLoop;
    private final int printerCount;

    public int getOrder() {
        return Order;
    }

    public void setOrder(int order) {
        Order = order;
    }

    public int getPrinterCount() {
        return printerCount;
    }

    public int getPrintLoop() {
        return printLoop;
    }

    public StateHolder(int printerCount, int printLoop) {
        this.printLoop = printLoop;
        this.printerCount = printerCount;
    }
}
