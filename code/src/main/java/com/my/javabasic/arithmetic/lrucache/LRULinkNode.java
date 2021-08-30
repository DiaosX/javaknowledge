package com.my.javabasic.arithmetic.lrucache;

public class LRULinkNode {
    public LRULinkNode prev;
    public LRULinkNode next;
    public String key;
    public String value;

    public LRULinkNode() {
    }

    public LRULinkNode(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
