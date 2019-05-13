package com.my.javabasic.designpattern.strategy;


public class ConcreteStrategy3 extends AbstractStrategy {
    @Override
    public double discount(double price) {
        return price * 0.08;
    }
}
