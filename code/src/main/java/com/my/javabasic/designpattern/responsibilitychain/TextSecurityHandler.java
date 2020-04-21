package com.my.javabasic.designpattern.responsibilitychain;

/**
 * 文本安全处理
 */
public interface TextSecurityHandler {
    String doHandle(String source, TextSecurityHandlerChain handleChain);
}
