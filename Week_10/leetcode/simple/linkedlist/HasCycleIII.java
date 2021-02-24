package leetcode.simple.linkedlist;

import leetcode.ListNode;

/**
 * Description: 141. 环形链表
 * 删除法
 * User: liqing@pluosi
 * Date: 2021-01-09
 * Time: 7:20 PM
 */
public class HasCycleIII {


    /**
     * 一个链表从头节点开始一个个删除，所谓删除就是让他的next指针指向他自己。如果没有环，从头结点一个个删除，最后肯定会删完
     * 如果是环形的，那么有两种情况，一种是o型的，一种是6型的
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {


        if (head == null || head.next == null) {
            return false;
        }

        if (head.next == head) {
            return true;
        }

        ListNode next = head.next;
        head.next = head;

        return hasCycle(next);
    }
}
