package com.my.javabasic;

import com.my.javabasic.arithmetic.Arithmetic;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArithmeticTest {

    @Autowired
    private Arithmetic arithmetic;

    @Test
    public void bubbleSortTest() {
        int[] source=buildSource();
        int[] sortedArr= arithmetic.bubbleSort(source.clone());


         Arrays.sort(source);
        Assert.assertArrayEquals(source,sortedArr);
    }

    @Test
    public void selectSortTest() {
        int[] source=buildSource();
        int[] sortedArr= arithmetic.selectSort(source.clone());


        Arrays.sort(source);
        Assert.assertArrayEquals(source,sortedArr);
    }

    @Test
    public void insertSortTest() {
        int[] source=buildSource();
        int[] sortedArr= arithmetic.insertSort(source.clone());


        Arrays.sort(source);
        Assert.assertArrayEquals(source,sortedArr);
    }


    @Test
    public void shellSortTest() {
        int[] source=buildSource();
        int[] sortedArr= arithmetic.shellSort(source.clone());


        Arrays.sort(source);
        Assert.assertArrayEquals(source,sortedArr);
    }

    int[] buildSource() {
        Random random = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }

        return arr;
    }
}
