package com.my.javabasic.designpattern.visitor;

public interface IElement {


    void handle(IVisitor visitor, DataContext ctx);

}
