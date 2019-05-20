package com.my.javabasic.fastjson;

public class CircularReference2 {

    public CircularReference1 getReference1() {
        return referenece1;
    }

    public void setReference1(CircularReference1 referenece1) {
        this.referenece1 = referenece1;
    }

    public CircularReference1 referenece1;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
