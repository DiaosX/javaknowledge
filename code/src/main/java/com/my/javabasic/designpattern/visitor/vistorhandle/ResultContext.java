package com.my.javabasic.designpattern.visitor.vistorhandle;

import java.util.ArrayList;
import java.util.List;

public class ResultContext {
    private final List<ResultHandler> handlerList = new ArrayList<>();
    private int startIndex = 0;

    public ResultContext() {

    }


    private void addHandler(ResultHandler handler) {
        this.handlerList.add(handler);
    }

    public void tryExecute() {
        for (int i = startIndex; i < handlerList.size(); i++) {
            doExecute(i);
        }
    }

    public void doExecute(int index) {
        try {
            if (index < this.handlerList.size()) {
                this.handlerList.get(index).handle();
            }
        } catch (PreHandlerRequiredException e) {
            startIndex = e.getPreHandlerIndex();
            doExecute(startIndex);
        }
    }
}
