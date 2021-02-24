package leetcode.simple;

import leetcode.ListNode;

/**
 * Description: 合并2个有序链表
 * 递归
 * User: liqing@pluosi
 * Date: 2021-01-08
 * Time: 11:03 PM
 */
public class MergeTwoListsII {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }
}
