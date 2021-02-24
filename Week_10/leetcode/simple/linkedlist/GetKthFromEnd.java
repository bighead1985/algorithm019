package leetcode.simple;

import leetcode.simple.linkedlist.ListNode;

/**
 * Description:
 * User: liqing@pluosi
 * Date: 2021-01-15
 * Time: 10:39 PM
 */
public class GetKthFromEnd {

    public ListNode getKthFromEnd(ListNode head, int k) {

        int length = 1;
        ListNode cur = head;
        while(cur.next!=null){
            cur = cur.next;
            length++;
        }

        cur = head;
        while(length > k){
            cur = cur.next;
            length--;
        }

        return cur;
    }
}
