package leetcode.mid.linkedlist;

import leetcode.ListNode;

/**
 * Description: 排序链表
 * User: liqing@pluosi
 * Date: 2021-01-14
 * Time: 10:39 PM
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head; //慢指针
        ListNode fast = head.next; //快指针

        while (fast != null && fast.next != null) { //快慢指针找到链表中点
            slow = slow.next; //慢指针走一步
            fast = fast.next.next; //快指针走两步
        }
        ListNode rightHead = slow.next; //链表第二部分的头节点
        slow.next = null; //cut 链表

        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);
        return merge(left, right);
    }

    public ListNode merge(ListNode h1, ListNode h2) { //合并两个有序链表
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                p.next = h1;
                h1 = h1.next;
            } else {
                p.next = h2;
                h2 = h2.next;
            }
            p = p.next;
        }
        if (h1 != null) p.next = h1;
        else if (h2 != null) p.next = h2;
        return dummy.next;

    }
}
