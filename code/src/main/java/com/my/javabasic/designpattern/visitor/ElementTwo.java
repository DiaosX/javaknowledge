package com.my.javabasic.designpattern.visitor;

public class ElementTwo implements IElement {
    @Override
    public void handle(IVisitor visitor, DataContext ctx) {
        visitor.visitTwo(this);
    }
}
