package com.my.javabasic.basicknowledge;


import java.util.Calendar;

public class ClassInitializeOrder {

    private static ClassInitializeOrder instance = new ClassInitializeOrder();

    //private final static int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);
    //private final static int CURRENT_YEAR = 300;
    private static int CURRENT_YEAR = 300;

    private int batchSize;

    public ClassInitializeOrder() {
        batchSize = CURRENT_YEAR - 100;
    }

    public static ClassInitializeOrder getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(ClassInitializeOrder.getInstance().batchSize);
    }
}
