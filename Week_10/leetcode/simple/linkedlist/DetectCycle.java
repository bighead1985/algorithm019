package leetcode.simple.linkedlist;

import leetcode.ListNode;

/**
 * Description: 142. 环形链表 II
 * User: liqing@pluosi
 * Date: 2021-01-09
 * Time: 7:20 PM
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        if(fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;

    }
}
