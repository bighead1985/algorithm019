package leetcode.mid;

/**
 * Description: 两两交换链表的节点
 * User: liqing@pluosi
 * Date: 2021-01-18
 * Time: 9:52 PM
 */
public class SwapPairs {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }
}
