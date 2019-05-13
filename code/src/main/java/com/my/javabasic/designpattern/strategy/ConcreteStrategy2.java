package com.my.javabasic.designpattern.strategy;

/**
 * 满500半价
 */
public class ConcreteStrategy2 extends AbstractStrategy {
    @Override
    public double discount(double price) {
        return price - 250.00;
    }
}