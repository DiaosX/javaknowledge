package com.my.javabasic.arithmetic;


import org.springframework.stereotype.Component;


@Component
public class Arithmetic {


    /**
     * 冒泡排序
     * 本质思想：每次把最大的号码挪到最右侧，然后连续挪10次即可保证从左至右从小到大排序
     */
    public int[] bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {

                if (arr[j] < arr[j - 1]) {
                    swap(arr,j,j-1);
                }
            }
        }

        return arr;
    }

    /**
     * 选择排序
     * 本质思想：从第i位开始往右，找出最小的一个值交换到第i位
     */
    public int[] selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int idx = i;
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[idx] > arr[j]) {
                    idx = j;
                }
            }

            if (i != idx) {
                swap(arr,idx,i);
            }
        }

        return arr;
    }


    /**
     * 插入排序
     * 本质思想：从第i位（i>=1）开始往左，依次轮换位置，直到大于i-1位置的数值停止
     */
    public int[] insertSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr,j,j-1);
                } else
                    break;
            }
        }

        return arr;
    }

    /**
     * 希尔排序
     */
    public int[] shellSort(int[] arr) {

        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {

            for (int j = gap; j < arr.length; j++) {

                int idx = j;
                while (idx - gap >= 0 && arr[idx] < arr[idx - gap]) {
                    swap(arr, idx, idx - gap);

                    idx = idx - gap;
                }
            }
        }
        return arr;
    }


    public void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }
}
