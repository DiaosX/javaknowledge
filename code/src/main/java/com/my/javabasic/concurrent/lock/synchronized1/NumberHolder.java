package com.my.javabasic.concurrent.lock.synchronized1;

public class NumberHolder {
    private int currentNumber = 0;

    public int getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(int currentNumber) {
        this.currentNumber = currentNumber;
    }
}
