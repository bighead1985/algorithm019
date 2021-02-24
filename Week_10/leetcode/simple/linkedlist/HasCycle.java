package leetcode.simple.linkedlist;

import leetcode.ListNode;

/**
 * Description: 141. 环形链表
 * User: liqing@pluosi
 * Date: 2021-01-09
 * Time: 7:20 PM
 */
public class HasCycle {

    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
