package com.my.javabasic.arithmetic.buildqueuewithstack;

public class BuildQueueWithStackTest {

    public static void main(String[] args) {
        BuildQueueWithStack queue = new BuildQueueWithStack();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        System.out.println("queue size=" + queue.size());
        String data = queue.dequeue();
        System.out.println("队头元素为：" + data);
        System.out.println("queue size=" + queue.size());
    }
}
