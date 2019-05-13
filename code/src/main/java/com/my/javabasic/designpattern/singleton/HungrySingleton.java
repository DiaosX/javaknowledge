package com.my.javabasic.designpattern.singleton;

public class HungrySingleton {

    public final static HungrySingleton instance;

    static {
        instance = new HungrySingleton();
    }

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}


