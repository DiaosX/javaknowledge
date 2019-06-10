package com.my.javabasic.fastjson.circularreference;

public class CircularReference1 {

    public CircularReference2 getReference2() {
        return reference2;
    }

    public void setReference2(CircularReference2 reference2) {
        this.reference2 = reference2;
    }

    private CircularReference2 reference2;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;


}
