package leetcode.simple.linkedlist;

import leetcode.ListNode;

/**
 * Description: 合并2个有序链表
 * 迭代法
 * User: liqing@pluosi
 * Date: 2021-01-08
 * Time: 11:03 PM
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        cur.next = l1 == null ? l2 : l1;
        return dummy.next;

    }
}
