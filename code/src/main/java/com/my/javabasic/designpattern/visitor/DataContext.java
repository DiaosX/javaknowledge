package com.my.javabasic.designpattern.visitor;

import java.util.ArrayList;
import java.util.List;

public class DataContext {
    private String name;
    private Integer status;
    private final List<IElement> elementList = new ArrayList<>();
    private int startIndex = 0;

    public boolean tryExecute(IVisitor visitor) {
        try {
            for (IElement element : elementList) {
                element.handle(visitor, this);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void addElement(IElement element) {
        elementList.add(element);
    }
}
