package com.my.javabasic.designpattern;

public class Singleton {

    public final static Singleton instance;

    static {
        instance = new Singleton();
    }

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }
}

class Singleton1 {

    private Singleton1() {
    }

    private Singleton1 instance;
    private static Object syncObj = new Object();

    public Singleton1 getInstance() {
        if (instance == null) {
            synchronized (syncObj) {
                if (instance == null) {
                    instance = new Singleton1();
                }
            }
        }
        return instance;
    }
}
