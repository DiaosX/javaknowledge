package com.my.javabasic.reflect;

import java.util.Date;

public class CustomReflectClass {

    private String name;

    public int count;

    @Override
    public String toString() {
        return "name=" + name + ",count=" + count;
    }

    /**
     * 公共方法
     *
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * 私有方法
     *
     * @return
     */
    private int getCount() {
        return this.count;
    }

    /**
     * 可继承的方法
     *
     * @return
     */
    protected boolean isSuccess() {
        return true;
    }

    public void printMessage(String message) {
        System.out.println(new Date() + message);
    }
}
