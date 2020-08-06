package com.my.javabasic.designpattern.pipeline;

import java.util.List;

public class HandlerContext {
    private int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    private List<String> stringList;

}
