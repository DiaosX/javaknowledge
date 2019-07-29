package com.my.javabasic.basicknowledge;


import java.util.List;

/**
 * List性能比对
 */
public class ListPerformanceCompare {
    static final int N = 100000;

    public static void arrayListAdd(List list) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("ArrayList.add,耗时：" + (end - start) + " 毫秒.");
    }

    public static void arrayListRemove(List list) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.remove(0);
        }
        long end = System.currentTimeMillis();
        System.out.println("ArrayList.remove,耗时：" + (end - start) + " 毫秒.");
    }

    public static void linkedListAdd(List list) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("LinkedList.add,耗时：" + (end - start) + " 毫秒.");
    }

    public static void linkedListRemove(List list) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.remove(0);
        }
        long end = System.currentTimeMillis();
        System.out.println("LinkedList.remove,耗时：" + (end - start) + " 毫秒.");
    }
}
