package com.my.javabasic.basicknowledge.classforname;

public class MyTestClass {

    static {
        System.out.println("静态区被执行了.");
    }

    public MyTestClass() {
        System.out.println("实例构造器被调用.");
    }
}
