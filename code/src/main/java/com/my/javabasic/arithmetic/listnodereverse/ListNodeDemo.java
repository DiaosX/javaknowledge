package com.my.javabasic.arithmetic.listnodereverse;

public class ListNodeDemo {

    /**
     * 翻转链表并打印结果
     *
     * @param head
     */
    public void reverseListNodeAndPrint(ListNode head) {
        System.out.println("翻转前结果为:");
        printListNode(head);
        ListNode newListNode = new ListNode();
        ListNode newHead = head.next;
        while (newHead != null) {
            ListNode tempHead = newHead;
            //摘取第一个节点
            ListNode tempNext = tempHead.next;
            tempHead.next = null;
            //摘下的节点插入新链表头节点之后
            ListNode temp = newListNode.next;
            newListNode.next = tempHead;
            tempHead.next = temp;

            newHead = tempNext;
        }
        System.out.println("翻转后结果为:");
        printListNode(newListNode);

    }

    private void printListNode(ListNode head) {
        StringBuilder builder = new StringBuilder();
        ListNode loop = head.next;
        while (loop != null) {
            builder.append(loop.value);
            if (loop.next != null) {
                builder.append("->");
            }

            loop = loop.next;
        }

        System.out.println(builder.toString());
    }

    public static void main(String[] args) {

        ListNode head = new ListNode();


        ListNode node1 = new ListNode();
        node1.value = 1;

        ListNode node2 = new ListNode();
        node2.value = 2;

        ListNode node3 = new ListNode();
        node3.value = 3;

        ListNode node4 = new ListNode();
        node4.value = 4;

        ListNode node5 = new ListNode();
        node5.value = 5;

        ListNode node6 = new ListNode();
        node6.value = 6;

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        ListNodeDemo op = new ListNodeDemo();

        op.reverseListNodeAndPrint(head);
    }
}
