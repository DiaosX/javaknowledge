package com.my.javabasic.arithmetic.mergesortedarray;

public class MergeSortedArrayTest {

    public static void main(String[] args) {
        //
        //testLRUCacheWithLinkedHashMap();
        //testLRUCacheWithCustom();
        int[] a = new int[]{1, 3, 4, 5};
        int[] b = new int[]{3, 3, 4, 5};
        //int[] c = new int[]{1,3, 3,3, 4, 5,5};
        int[] c = mergeArray(a, b);
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i] + "");
        }
    }

    public static int[] mergeArray(int[] a, int[] b) {
        //快慢指针
        int i = 0;
        int j = 0;
        int[] c = new int[a.length + b.length];
        while (i < a.length || j < b.length) {
            if (i == a.length) {
                while (j < b.length) {
                    c[i + j] = b[j];
                    j++;
                }
                break;
            }
            if (j == b.length) {
                while (i < a.length) {
                    c[i + j] = a[i];
                    i++;
                }
                break;
            }
            if (a[i] < b[j]) {
                c[i + j] = a[i];
                i++;
            } else {
                c[i + j] = b[j];
                j++;
            }
        }
        return c;
    }
}
