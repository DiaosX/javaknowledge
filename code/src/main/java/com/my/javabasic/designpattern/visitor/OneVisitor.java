package com.my.javabasic.designpattern.visitor;

public class OneVisitor implements IVisitor {
    @Override
    public void visitOne(ElementOne ele) {

        System.out.println("访问ElementOne");
    }

    @Override
    public void visitTwo(ElementTwo ele) {
        System.out.println("访问ElementTwo");
    }
}
