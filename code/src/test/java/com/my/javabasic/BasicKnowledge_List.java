package com.my.javabasic;

import com.my.javabasic.basicknowledge.ListPerformanceCompare;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasicKnowledge_List {

    @Test
    public void compareForInteger() {

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        ListPerformanceCompare.arrayListAdd(arrayList);
        ListPerformanceCompare.linkedListAdd(linkedList);

        ListPerformanceCompare.arrayListRemove(arrayList);
        ListPerformanceCompare.linkedListRemove(linkedList);
    }
}
