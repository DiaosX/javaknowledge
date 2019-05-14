package com.my.javabasic.basicknowledge;


/*
分支流控语句
 */
public class ControlFlow {

    private int[] items = new int[100];

    public ControlFlow() {
        for (int i = 0; i < 100; i++) {
            items[i] = i++;
        }
    }

    public void enumerateArrayUseForeach() {
        for (int i : items) {
            System.out.println(i);
        }
    }

    public void enumerateArrayUseFor() {
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }
    }
}
