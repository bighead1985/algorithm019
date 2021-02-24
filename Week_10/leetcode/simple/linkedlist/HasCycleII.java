package leetcode.simple;

import leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: 141. 环形链表
 * 哈希法
 * User: liqing@pluosi
 * Date: 2021-01-09
 * Time: 7:20 PM
 */
public class HasCycleII {


    public boolean hasCycle(ListNode head) {

        Set<ListNode> set = new HashSet<>();

        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;

        }
        return false;

    }
}
