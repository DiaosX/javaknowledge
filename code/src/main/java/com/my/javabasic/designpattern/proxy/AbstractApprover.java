package com.my.javabasic.designpattern.proxy;


/**
 * 抽象审批者
 */
public interface AbstractApprover {

    /**
     * 审批操作
     *
     * @param message
     */
    void approve(String message);

    /**
     * 获取审批结果
     *
     * @return
     */
    String getAdvice();
}
