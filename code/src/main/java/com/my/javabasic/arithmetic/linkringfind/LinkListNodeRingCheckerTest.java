package com.my.javabasic.arithmetic.linkringfind;

public class LinkListNodeRingCheckerTest {

    public static void main(String[] args) {
        LinkListNode head = new LinkListNode();
        LinkListNode node1 = new LinkListNode(1);
        head.next = node1;
        LinkListNode node2 = new LinkListNode(2);
        node1.next = node2;
        LinkListNode node3 = new LinkListNode(3);
        node2.next = node3;
        LinkListNode node4 = new LinkListNode(4);
        node3.next = node4;
        LinkListNode node5 = new LinkListNode(5);
        node4.next = node5;
        node5.next = node3;

        LinkListNodeRingChecker checker = new LinkListNodeRingChecker();
        System.out.println(checker.hasRingInLinkList(head.next));
    }
}
