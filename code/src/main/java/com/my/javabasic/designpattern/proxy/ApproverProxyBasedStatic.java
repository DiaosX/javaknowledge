package com.my.javabasic.designpattern.proxy;

/**
 * 静态代理类
 */
public class ApproverProxyBasedStatic implements AbstractApprover {

    private AbstractApprover approver;

    public ApproverProxyBasedStatic(AbstractApprover approver) {
        this.approver = approver;
    }

    @Override
    public void approve(String message) {
        //在被代理对象方法前执行操作
        System.out.println("在代理类执行，执行方法前执行");
        this.approver.approve(message);
        System.out.println("在代理类执行，执行方法后执行");
    }

    @Override
    public String getAdvice() {
        return "同意";
    }
}
