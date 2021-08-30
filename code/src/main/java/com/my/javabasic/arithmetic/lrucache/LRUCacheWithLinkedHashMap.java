package com.my.javabasic.arithmetic.lrucache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheWithLinkedHashMap {
    private int capacity;
    private LinkedHashMap<String, String> cacheMap;

    public LRUCacheWithLinkedHashMap(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new LinkedHashMap<String, String>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                System.out.println("移除元素为：" + eldest.getKey());
                return size() > capacity;
            }
        };
    }

    public String get(String key) {
        // 自动调整顺序，不存在返回
        return cacheMap.getOrDefault(key, "none");
    }

    public void put(String key, String value) {
        // 自动插入，自动判满删除
        cacheMap.put(key, value);
    }
}
