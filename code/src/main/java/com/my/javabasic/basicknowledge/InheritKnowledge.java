package com.my.javabasic.basicknowledge;

public class InheritKnowledge {

    public void Test() {
        new Child().Say();
        new Child().Payment();
    }
}

class Parent {

    public void Say() {
        System.out.println("I'm parent");
    }

    public final void Payment() {
        System.out.println("Oh my god!");
    }

}

class Child extends Parent {

    @Override
    public void Say() {
        System.out.println("I'm Child");
    }

    // can not do this
    //public void  Payment(){}
}
