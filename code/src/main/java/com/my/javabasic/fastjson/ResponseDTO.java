package com.my.javabasic.fastjson;

public class ResponseDTO {

    public Person[] getFamily() {
        return family;
    }

    public void setFamily(Person[] family) {
        this.family = family;
    }

    public Person[] getStranger() {
        return stranger;
    }

    public void setStranger(Person[] stranger) {
        this.stranger = stranger;
    }

    private Person[] family;

    private Person[] stranger;
}
