//package com.my.javabasic;
//
//
//import com.my.javabasic.leetcode.ListNode;
//import com.my.javabasic.leetcode.PartitionList;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class LeetCode_PartitionListTest {
//
//    private ListNode head = new ListNode();
//
//    @Before
//    public void setUp() {
//
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(4);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(2);
//        ListNode node5 = new ListNode(5);
//        ListNode node6 = new ListNode(2);
//
//        head.setNext(node1);
//        node1.setNext(node2);
//        node2.setNext(node3);
//        node3.setNext(node4);
//        node4.setNext(node5);
//        node5.setNext(node6);
//
//    }
//
//
//    /**
//     * head = 1->4->3->2->5->2, x = 3
//     */
//    @Test
//    public void testPartitionList_input_3() {
//
//        PartitionList list = new PartitionList();
//        list.printPartitionListResult(head, 3);
//    }
//
//    @Test
//    public void testPartitionList_input_5() {
//
//        PartitionList list = new PartitionList();
//        list.printPartitionListResult(head, 5);
//    }
//
//    @Test
//    public void testPartitionList_input_4() {
//
//        PartitionList list = new PartitionList();
//        list.printPartitionListResult(head, 4);
//    }
//}
