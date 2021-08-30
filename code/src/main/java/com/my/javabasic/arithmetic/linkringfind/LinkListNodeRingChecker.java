package com.my.javabasic.arithmetic.linkringfind;

public class LinkListNodeRingChecker {
    public boolean hasRingInLinkList(LinkListNode root) {
        LinkListNode quick = root.next;
        LinkListNode slow = root;
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
            if (quick == slow) {
                return true;
            }
        }
        return false;
    }
}
