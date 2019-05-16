package com.my.javabasic.designpattern.proxy;

public class ConcreteApprover implements AbstractApprover {
    @Override
    public void approve(String message) {
        System.out.println("ConcreteApprover-approve,获取到的信息是:" + message);
    }

    @Override
    public String getAdvice() {
        System.out.println("ConcreteApprover-getAdvice");
        return "同意";
    }
}
