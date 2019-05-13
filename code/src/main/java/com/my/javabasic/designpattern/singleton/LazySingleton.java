package com.my.javabasic.designpattern.singleton;

public class LazySingleton {
    private LazySingleton() {
    }

    private static LazySingleton instance;
    private static Object syncObj = new Object();

    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (syncObj) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
