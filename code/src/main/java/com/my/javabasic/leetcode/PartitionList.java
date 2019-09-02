package com.my.javabasic.leetcode;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，
 * 使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * 示例:
 * <p>
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PartitionList {
    public String calcPartitionList(ListNode sourceList, int x) {

        ListNode leftListHead = new ListNode();
        ListNode rightListHead = new ListNode();
        if (null != sourceList.getNext()) {
            splitSourceList(leftListHead, rightListHead, sourceList.getNext(), x);
        }
        ListNode leftLastNode = getLastNode(leftListHead);
        StringBuilder builder = new StringBuilder();

        //如果左边链表为空，则直接输出右边量表
        if (leftLastNode == leftListHead) {
            buildDisplayResult(rightListHead.getNext(), builder);
        } else {
            leftLastNode.setNext(rightListHead.getNext());
            buildDisplayResult(leftListHead.getNext(), builder);
        }
        return builder.toString();
    }

    private ListNode getLastNode(ListNode listHead) {
        if (null == listHead.getNext()) {
            return listHead;
        } else {
            return getLastNode(listHead.getNext());
        }
    }

    private static void buildDisplayResult(ListNode node, StringBuilder builder) {

        if (null == node.getNext()) {
            builder.append(node.getValue());
            return;
        }
        builder.append(node.getValue())
                .append("->");

        buildDisplayResult(node.getNext(), builder);
    }

    private void splitSourceList(ListNode leftListHead, ListNode rightListHead, ListNode sourceList, int x) {
        if (null == sourceList) {
            return;
        }
        if (sourceList.getValue() >= x) {
            ListNode node = new ListNode(sourceList.getValue());
            rightListHead.setNext(node);
        } else {
            ListNode node = new ListNode(sourceList.getValue());
            leftListHead.setNext(node);
        }
        ListNode nextLeft = null == leftListHead.getNext() ? leftListHead : leftListHead.getNext();
        ListNode nextRight = null == rightListHead.getNext() ? rightListHead : rightListHead.getNext();
        splitSourceList(nextLeft, nextRight, sourceList.getNext(), x);
    }

    public static void main(String[] args) {

        //初始化数据
        ListNode origialList = setUp();

        StringBuilder resultBuilder = new StringBuilder();
        buildDisplayResult(origialList.getNext(), resultBuilder);
        System.out.println("原始列表为：" + resultBuilder.toString());

        PartitionList list2 = new PartitionList();
        System.out.println("x=2,结果为：" + list2.calcPartitionList(origialList, 2));

        PartitionList list3 = new PartitionList();
        System.out.println("x=3,结果为：" + list3.calcPartitionList(origialList, 3));

        PartitionList list4 = new PartitionList();
        System.out.println("x=4,结果为：" + list4.calcPartitionList(origialList, 4));

        PartitionList list5 = new PartitionList();
        System.out.println("x=5,结果为：" + list5.calcPartitionList(origialList, 5));

        ListNode origialList1 = setUp1();

        PartitionList list6 = new PartitionList();
        System.out.println("x=0,结果为：" + list5.calcPartitionList(origialList1, 0));

        System.out.println("测试完毕.");

    }

    private static ListNode setUp() {

        ListNode origialList = new ListNode();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);

        origialList.setNext(node1);
        return origialList;
    }

    private static ListNode setUp1() {
        ListNode origialList = new ListNode();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);

        node1.setNext(node2);

        origialList.setNext(node1);
        return origialList;
    }


}

class ListNode {

    public int getValue() {
        return value;
    }

    public int value;

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode next;

    public ListNode() {
        this.value = 0;
    }

    public ListNode(int value) {
        this.value = value;
    }
}
