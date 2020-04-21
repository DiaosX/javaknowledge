package com.my.javabasic.designpattern.responsibilitychain;

import java.util.ArrayList;
import java.util.List;

public class TextSecurityHandlerChain {
    private List<TextSecurityHandler> chains = new ArrayList<>();
    private int handlerIndex = 0;

    public TextSecurityHandlerChain addSecurityHandler(TextSecurityHandler handler) {
        this.chains.add(handler);
        return this;
    }

    public String applyHandle(String source) {
        if (chains.size() == 0) {
            return source;
        }
        if (handlerIndex <= chains.size() - 1) {
            TextSecurityHandler handler = chains.get(handlerIndex);
            handlerIndex++;
            return handler.doHandle(source, this);
        }
        return source;
    }
}
