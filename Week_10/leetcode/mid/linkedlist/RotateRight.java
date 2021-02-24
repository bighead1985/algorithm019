package leetcode.mid.linkedlist;


import leetcode.ListNode;

/**
 * Description:
 * User: liqing@pluosi
 * Date: 2021-01-13
 * Time: 10:17 PM
 */
public class RotateRight {


    /**
     * 总的解法就是寻找链表断开处
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        //统计链表长度,并找到tail节点
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        k = k % length;
        if (k == 0) {
            return head;
        }


        //确定链表断开处的前一个节点，需要移动length-k-1步，自己画图推导
        ListNode pivot = head;
        for (int i = 0; i < length - k - 1; i++) {
            pivot = pivot.next;
        }


        //将新的头节点设置在断开处的下一个节点
        ListNode newHead = pivot.next;
        tail.next = head;
        pivot.next = null;

        return newHead;


    }
}
