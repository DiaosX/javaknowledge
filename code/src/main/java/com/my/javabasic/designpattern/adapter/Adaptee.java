package com.my.javabasic.designpattern.adapter;

public class Adaptee {

    public String print(String msg, String name) {
        return "i am adaptee:" + msg + " " + name;
    }

}
