package com.my.javabasic.dynamicproxy;


import java.util.List;

public interface ICrud {

    int update(String sqlText);

    List<String> select(String sqlText);

    void insert();
}
