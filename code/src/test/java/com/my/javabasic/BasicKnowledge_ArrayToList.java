package com.my.javabasic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * java中数组转化为List的方式
 * Arrays.asList() 和Collection.addAll
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BasicKnowledge_ArrayToList {

    /**
     * 使用Arrays.asList()方法
     */
    @Test
    public void arrayToList1() {
        String[] strArr = new String[]{"item1", "item2"};
        List<String> strList = Arrays.asList(strArr);
        try {
            //使用Arrays.asList后的数组不能使用add,remove
            //抛出java.lang.UnsupportedOperationException异常
            strList.add("item3");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //如果使用Arrays.asList转化后还想添加元素，需要转化为ArrayList<>
        List<String> newStrList = new ArrayList<>(strList);
        System.out.println("添加前=" + strList.size());
        newStrList.add("item3");
        System.out.println("添加后=" + newStrList.size());
    }

    /**
     * 使用Collection.addAll
     */
    @Test
    public void arrayToList2() {
        String[] strArr = new String[]{"item1", "item2"};
        List<String> strList = new ArrayList<>(strArr.length);
        Collections.addAll(strList, strArr);
        System.out.println("添加前=" + strList.size());
        //使用Collections.addAll后可以添加元素
        strList.add("item3");
        System.out.println("添加后=" + strList.size());
    }

    /**
     * 使用list.toArray方法
     */
    @Test
    public void listToArray1() {
        List<String> strList = new ArrayList<>();
        strList.add("item1");
        strList.add("item2");

        String[] strArr1 = new String[strList.size()];
        String[] strArr2 = strList.toArray(strArr1);
        System.out.println("两个数组是否相等:" + (strArr1 == strArr2));
    }

    @Test
    public void listToArray2() {
        List<String> strList = new ArrayList<>();
        strList.add("item1");
        strList.add("item2");

        String[] strArr1 = new String[0];
        String[] strArr2 = strList.toArray(strArr1);
        System.out.println("两个数组是否相等:" + (strArr1 == strArr2));
    }

    @Test
    public void listToArray3() {
        List<String> strList = new ArrayList<>();
        strList.add("item1");
        strList.add("item2");

        String[] strArr1 = new String[strList.size() + 1];
        String[] strArr2 = strList.toArray(strArr1);
        System.out.println("两个数组是否相等:" + (strArr1 == strArr2));
        System.out.println(Arrays.toString(strArr2));
    }

    /**
     * 使用strList.stream().toArray方法
     */
    @Test
    public void listToArray4() {
        List<String> strList = new ArrayList<>();
        strList.add("item1");
        strList.add("item2");
        //List<String> newStrList=Arrays.asList("item1","item2");
        String[] strArr = strList.stream().toArray(String[]::new);
        System.out.println(Arrays.toString(strArr));
    }
}
