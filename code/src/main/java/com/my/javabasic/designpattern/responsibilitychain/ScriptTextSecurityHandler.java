package com.my.javabasic.designpattern.responsibilitychain;

public class ScriptTextSecurityHandler implements TextSecurityHandler {
    @Override
    public String doHandle(String source, TextSecurityHandlerChain handleChain) {
        String target = source;
        System.out.println("ScriptHandler-处理前:" + target);
        target = target.replace("Script", "").replace("script", "");
        System.out.println("ScriptHandler-处理后:" + target);
        //选择是否执行下一个处理器
        String handledSource = handleChain.applyHandle(target);
        System.out.println("Script handler end");
        return handledSource;
    }
}
