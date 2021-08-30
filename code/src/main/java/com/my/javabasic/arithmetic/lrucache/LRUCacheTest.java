package com.my.javabasic.arithmetic.lrucache;

public class LRUCacheTest {
    public static void main(String[] args) {
        //
        //testLRUCacheWithLinkedHashMap();
        testLRUCacheWithCustom();
    }

    private static void testLRUCacheWithCustom() {
        LRUCache lruCache = new LRUCache(5);
        lruCache.put("1", "a");
        lruCache.put("2", "b");
        lruCache.put("3", "c");
        lruCache.put("4", "d");
        lruCache.put("5", "e");

        System.out.println("插入5条数据");
        String value1 = lruCache.get("1");
        System.out.println("读取key为1的value=l" + value1);
        System.out.println("当新插入数据时，key为2的元素应该被淘汰");
        lruCache.put("6", "f");
    }

    public static void testLRUCacheWithLinkedHashMap() {
        LRUCacheWithLinkedHashMap m1 = new LRUCacheWithLinkedHashMap(5);
        m1.put("1", "a");
        m1.put("2", "b");
        m1.put("3", "c");
        m1.put("4", "d");
        m1.put("5", "e");

        System.out.println("插入5条数据");
        String value1 = m1.get("1");
        System.out.println("读取key为1的value=l" + value1);
        System.out.println("当新插入数据时，key为2的元素应该被淘汰");
        m1.put("6", "f");
    }
}
