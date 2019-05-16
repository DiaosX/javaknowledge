package com.my.javabasic.dynamicproxy;

import java.util.ArrayList;
import java.util.List;

public class Crud implements ICrud {

    @Intercept
    public int update(String sqlText) {
        System.out.println("Crud-update");
        return 1;

    }

    @Intercept
    public List<String> select(String sqlText) {
        System.out.println("Crud-select");
        return new ArrayList<>();
    }

    public void insert() {
        System.out.println("Crud-insert");
    }
}
