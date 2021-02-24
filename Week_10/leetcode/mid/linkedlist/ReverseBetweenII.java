package leetcode.mid.linkedlist;

import leetcode.ListNode;

/**
 * Description: 反转链表II
 * 递归法2
 * User: liqing@pluosi
 * Date: 2021-01-12
 * Time: 11:13 PM
 */
public class ReverseBetweenII {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    ListNode reverseBetween(ListNode head, int left, int right) {


        /**
         * 如果left==right ，则链表不需要做任何反转，直接返回
         */
        if (left == right) {
            return head;
        }

        ListNode preL = null;
        ListNode nodeL = head;
        ListNode nodeR = null;
        ListNode rNext = null;


        /**
         * 开始遍历链表，同时放置各个上述需要的节点指针
         */
        int i = 1;
        ListNode cur = head;
        while (i <= right) {
            if (i == left - 1) {
                preL = cur;
            }
            if (i == left) {
                nodeL = cur;
            }
            if (i == right) {
                nodeR = cur;
                rNext = cur.next;
            }
            cur = cur.next;
            i++;
        }


        /**
         * 切断链表的尾部,并反转指定的链表区间
         */
        if (null != nodeR) {
            nodeR.next = null;
        }
        ListNode newHead = reverseList(nodeL);

        /**
         * 重新连接新的链表并返回
         */
        if (preL == null) {
            nodeL.next = rNext;
            return newHead;
        } else {
            preL.next = nodeR;
            nodeL.next = rNext;
            return head;
        }

    }
}
