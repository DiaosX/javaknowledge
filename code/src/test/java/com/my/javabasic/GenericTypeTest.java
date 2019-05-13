package com.my.javabasic;


import com.my.javabasic.generic.CustomGenericInterfaceImpl;
import com.my.javabasic.generic.CustomGenericType;
import com.my.javabasic.generic.GenericTypeMethod;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GenericTypeTest {

    @Test
    public void compareGenericType() {

        List<String> lstType1 = new ArrayList<String>();
        List<Integer> lstType2 = new ArrayList<Integer>();

        System.out.println("list class1=" + lstType1.getClass().getName());
        System.out.println("list class2=" + lstType2.getClass().getName());
        System.out.println("list clzz compare= " + (lstType1.getClass() == lstType2.getClass()));

        CustomGenericType<String> type1 = new CustomGenericType<>("1");
        CustomGenericType<Integer> type2 = new CustomGenericType<>(1);

        String clz1 = type1.getClass().getName();
        String clz2 = type2.getClass().getName();

        System.out.println("custom class1=" + clz1);
        System.out.println("custom class2=" + clz2);
        System.out.println("custom clzz compare= " + (lstType1.getClass() == lstType2.getClass()));
    }


    /**
     * 获取实际的泛型类型参数
     */
    @Test
    public void getActualGenericTypeParameterTypeFromClass() {
        //获取实际参数类型:String
        new CustomGenericType<String>() {
        }.pringActualGenericTypeParameterType();
        //获取实际参数类型:Integer
        new CustomGenericType<Integer>() {
        }.pringActualGenericTypeParameterType();
    }

    /**
     * 从接口获取实际的泛型类型参数
     */
    @Test
    public void getActualGenericTypeParameterTypeFromInterface() {
        CustomGenericInterfaceImpl genericInterface = new CustomGenericInterfaceImpl();
        genericInterface.printActualGenericType();
    }
}
