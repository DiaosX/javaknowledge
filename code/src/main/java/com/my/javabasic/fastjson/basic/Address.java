package com.my.javabasic.fastjson.basic;

public class Address {
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    private String city;
    private int postCode;
    private String road;
    private String houseNumber;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("city=").append(city).append("&");
        builder.append("postCode=").append(postCode).append("&");
        builder.append("road=").append(road).append("&");
        builder.append("houseNumber=").append(houseNumber).append("&");
        return builder.toString();
    }
}
