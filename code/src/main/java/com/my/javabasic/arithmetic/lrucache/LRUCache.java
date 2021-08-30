package com.my.javabasic.arithmetic.lrucache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private LRULinkNode head;
    private LRULinkNode tail;
    private int capacity;
    private int size;
    private Map<String, LRULinkNode> cacheMap = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new LRULinkNode();
        this.tail = head;
    }


    public void put(String key, String value) {
        LRULinkNode current = this.cacheMap.get(key);
        if (current == null) {
            current = new LRULinkNode(key, value);
            //超出了容量
            if (this.size >= this.capacity) {
                this.cacheMap.remove(this.tail.key);
                this.delete(this.tail);
            }
            this.insert(current);
            this.cacheMap.put(key, current);
        }
    }

    private void delete(LRULinkNode current) {
        current.prev.next = current.next;
        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            this.tail = current.prev;
            this.tail.next = null;
        }
        this.size--;
    }

    private void insert(LRULinkNode current) {
        //插入到表头
        current.prev = this.head;
        current.next = this.head.next;
        if (this.head.next == null) {
            this.tail = current;
            this.tail.next = null;
        } else {
            this.head.next.prev = current;
        }
        this.head.next = current;
        this.size++;
    }

    public String get(String key) {
        LRULinkNode current = this.cacheMap.get(key);
        if (current == null) {
            return "";
        }
        LRULinkNode save = current;
        this.delete(current);
        this.insert(save);
        return current.value;
    }
}
