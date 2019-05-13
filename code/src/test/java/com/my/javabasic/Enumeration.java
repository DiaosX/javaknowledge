package com.my.javabasic;


import com.my.javabasic.enumtype.CustomEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Enumeration {

    @Test
    public void loopCustomEnumElement() {
        for (CustomEnum customEnum : CustomEnum.values()) {
            String format = "name=%s,ordinal=%s,value=%s,declaringClass=%s";
            String message = String.format(format,
                    customEnum.name(),
                    customEnum.ordinal(),
                    customEnum.getValue(),
                    customEnum.getDeclaringClass().getName());
            System.out.println(message);
        }
    }

    @Test
    public void printEnumClass() {
        CustomEnum.class.getDeclaredClasses();
    }

    @Test
    public void useEnumTypeInSwitch() {
        for (int i = 0; i < CustomEnum.values().length; i++) {
            printEnumValue(CustomEnum.values()[i]);
        }
    }

    private void printEnumValue(CustomEnum type) {
        switch (type) {
            case MON:
                System.out.println("礼拜一");
                break;
            case TUE:
                System.out.println("礼拜二");
                break;
            case THU:
                System.out.println("礼拜三");
                break;
            case WED:
                System.out.println("礼拜四");
                break;
            case FRI:
                System.out.println("礼拜五");
                break;
            case SAT:
                System.out.println("礼拜六");
                break;
            case SUN:
                System.out.println("礼拜日");
                break;
            default:
                System.out.println("无效的枚举值");
                break;
        }
    }

    @Test
    public void useEnumSetAndEnumMap() {
        System.out.println("-------------EnumSet----------------");
        EnumSet<CustomEnum> setAll = EnumSet.allOf(CustomEnum.class);
        for (CustomEnum customEnum : setAll) {
            System.out.println(customEnum.toString());
        }
        System.out.println("-------------EnumMap----------------");
        EnumMap<CustomEnum, String> mapAll = new EnumMap(CustomEnum.class);
        mapAll.put(CustomEnum.SAT, "SAT");
        mapAll.put(CustomEnum.SUN, "SUN");
        for (Iterator<Map.Entry<CustomEnum, String>> iter = mapAll.entrySet().iterator(); iter.hasNext(); ) {
            Map.Entry<CustomEnum, String> entry = iter.next();
            System.out.println(entry.getKey().name() + ":" + entry.getValue());
        }
    }

    @Test
    public void useEnumValueOf() {
        CustomEnum value = CustomEnum.valueOf("SUN");
        System.out.println(value.toString());
        CustomEnum value2 = CustomEnum.valueOf(CustomEnum.class, "SUN");
        System.out.println(value2.toString());
//        CustomEnum value1 = CustomEnum.valueOf("sun");
//        System.out.println(value1.toString());
    }
}
