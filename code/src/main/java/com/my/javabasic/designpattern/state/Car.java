package com.my.javabasic.designpattern.state;

import java.util.HashMap;

public class Car {

    private ICarState carState;

    public Car(ICarState carState) {
        this.carState = carState;
    }


    public void setState(ICarState carState) {
        //Map<String,String> cff=new HashMap<>();
    }
}
