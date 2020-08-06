package com.my.javabasic.designpattern.adapter;

public class Adapter implements ITarget {
    private final Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void print(String msg) {
        String name = "ddd";
        String myMsg = this.adaptee.print(msg, name);
        System.out.println(myMsg);
    }
}
