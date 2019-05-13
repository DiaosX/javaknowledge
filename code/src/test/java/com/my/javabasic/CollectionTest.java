package com.my.javabasic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CollectionTest {

    @Test
    public void getAnnotationFromClass() {


    }

    /*
    List是一个有序的，允许重复元素的集合类，并且提供了索引方式访问
     */
    @Test
    public void useList() {
        List<String> names = new ArrayList<>();
        names.add("name1");
        names.add("name2");
        names.add("name3");
        names.add("name4");
        names.add("name5");

        System.out.println("------遍历---------");

        if (names.isEmpty()) {
            System.out.println("集合为空.");
            return;
        }
        //遍历
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("------个数---------");
        //list的元素个数
        System.out.println(names.size());
    }

    /*
       Set中不能包含重复的元素,如果添加多个相同元素，则自动过滤
     */
    @Test
    public void useSet() {
        Set<String> names = new HashSet<>();
        names.add("name1");
        names.add("name1");
        names.add("name2");
        names.add("name2");
        System.out.println("------遍历---------");
        if (names.isEmpty()) {
            System.out.println("集合为空.");
            return;
        }
        //遍历
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("------个数---------");
        //list的元素个数
        System.out.println(names.size());
    }
}

