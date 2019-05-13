package com.my.javabasic.designpattern.strategy;

public class StrategyContext {
    private AbstractStrategy strategy;

    public StrategyContext(AbstractStrategy strategy) {
        this.strategy = strategy;
    }

    public StrategyContext() {

    }


    public void setStrategy(AbstractStrategy strategy) {
        this.strategy = strategy;
    }

    public double getPrice(double price) {
        return this.strategy.discount(price);
    }
}
