package com.my.javabasic.designpattern.strategy;

/**
 * 满199-100
 */
public class ConcreteStrategy1 extends AbstractStrategy {
    @Override
    public double discount(double price) {
        return price - 100.00;
    }
}
