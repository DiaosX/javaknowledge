package com.my.javabasic.enumtype;

/*
枚举类型是JDK1.5进入
所有的枚举类型隐式继承 java.lang.Enum抽象类
 */
public enum CustomEnum {

    MON(1), TUE(2), WED(3), THU(4), FRI(5), SAT(6), SUN(7);

    private int value;

    private CustomEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
