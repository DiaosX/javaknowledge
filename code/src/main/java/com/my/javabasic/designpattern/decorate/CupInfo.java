package com.my.javabasic.designpattern.decorate;

public class CupInfo {

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double price;
    public String color;
    public boolean isKeepWarm;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isKeepWarm() {
        return isKeepWarm;
    }

    public void setKeepWarm(boolean keepWarm) {
        isKeepWarm = keepWarm;
    }

    @Override
    public String toString() {
        return "price=" + this.getPrice() + "," +
                "color=" + this.getColor() + "," +
                "isKeepWarm=" + this.isKeepWarm();
    }
}
