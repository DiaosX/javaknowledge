package com.my.javabasic.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

    public ListNode1 partition(ListNode1 head, int x) {
        ListNode1 leftListHead = new ListNode1(0);
        ListNode1 rightListHead = new ListNode1(0);
        //如果只有一个节点
        if (null == head) {
            return head;
        }
        if (null == head.next) {
            leftListHead.next = head;
            return leftListHead.next;
        }

        splitSourceList(leftListHead, rightListHead, head, x);
        if (leftListHead.next == null) {
            return rightListHead.next;
        }
        if (rightListHead.next == null) {
            return leftListHead.next;
        }

        ListNode1 leftLastNode = getLastNode(leftListHead);
        //如果左边链表为空，则直接输出右边量表
        if (leftLastNode != leftListHead) {
            leftLastNode.next = rightListHead.next;
        }
        return leftListHead.next;
    }


    private ListNode1 getLastNode(ListNode1 listHead) {
        if (null == listHead.next) {
            return listHead;
        } else {
            return getLastNode(listHead.next);
        }
    }


    private void splitSourceList(ListNode1 leftListHead, ListNode1 rightListHead, ListNode1 sourceList, int x) {
        if (null == sourceList) {
            return;
        }
        if (sourceList.val >= x) {
            ListNode1 node = new ListNode1(sourceList.val);
            rightListHead.next = node;
        } else {
            ListNode1 node = new ListNode1(sourceList.val);
            leftListHead.next = node;
        }
        ListNode1 nextLeft = null == leftListHead.next ? leftListHead : leftListHead.next;
        ListNode1 nextRight = null == rightListHead.next ? rightListHead : rightListHead.next;
        splitSourceList(nextLeft, nextRight, sourceList.next, x);
    }
}

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[2];
        for (int index = 0; index < 2; index++) {
            String part = "1";
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode1 stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode1 dummyRoot = new ListNode1(0);
        ListNode1 ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ListNode1(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode1 node) {
        if (node == null) {
            return "[]";
        }
        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        ListNode1 head = stringToListNode("1,1");

        int x = Integer.parseInt("0");

        ListNode1 ret = new Solution().partition(head, x);

        String out = listNodeToString(ret);

        System.out.print(out);

    }


}

class ListNode1 {

    public int getValue() {
        return val;
    }

    public int val;

    public ListNode1 getNext() {
        return next;
    }

    public void setNext(ListNode1 next) {
        this.next = next;
    }

    public ListNode1 next;

    public ListNode1() {
        this.val = 0;
    }

    public ListNode1(int value) {
        this.val = value;
    }
}

