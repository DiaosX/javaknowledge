package com.my.javabasic.concurrent.lock.synchronized2;


/*
三线程打印ABC的问题

 */
public class NumberPrinter extends Thread {

    private final String printContent;
    private final StateHolder holder;
    private final int printOrder;

    public NumberPrinter(String printContent, int printOrder, StateHolder holder) {
        this.printContent = printContent;
        this.holder = holder;
        this.printOrder = printOrder;
    }

    @Override
    public void run() {
        for (int i = 0; i < holder.getPrintLoop(); i++) {
            synchronized (holder) {
                while (holder.getOrder() != this.printOrder) {
                    try {
                        holder.wait();//阻塞当前线程，释放锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(i + "-" + printContent);
                //移动到下一个打印线程
                holder.setOrder(holder.getOrder() % this.holder.getPrinterCount() + 1);
                holder.notifyAll();
            }
        }
    }
}
