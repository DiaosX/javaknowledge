package com.my.javabasic.designpattern.visitor;

public class ElementOne implements IElement {
    @Override
    public void handle(IVisitor visitor, DataContext ctx) {

        visitor.visitOne(this);
    }
}
