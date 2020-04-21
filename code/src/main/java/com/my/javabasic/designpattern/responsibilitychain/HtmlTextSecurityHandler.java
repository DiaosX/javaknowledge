package com.my.javabasic.designpattern.responsibilitychain;

public class HtmlTextSecurityHandler implements TextSecurityHandler {
    @Override
    public String doHandle(String source, TextSecurityHandlerChain handleChain) {
        String target = source;
        System.out.println("HtmlHandler-处理前:" + target);
        target = target.replace("<", "&lt;").replace(">", "&gt;");
        System.out.println("HtmlHandler-处理后:" + target);
        //选择是否执行下一个处理器
        String handledSource = handleChain.applyHandle(target);
        System.out.println("html handler end");
        return handledSource;
    }
}
