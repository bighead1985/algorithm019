package leetcode.simple.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 104.二叉树的最大深度
 * User: liqing@pluosi
 * Date: 2021-02-06
 * Time: 11:55 AM
 */


public class MaxDepth {

    /**
     * DFS
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth1(root.left);
            int rightHeight = maxDepth1(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    /**
     * BFS
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {

        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            depth++;
        }
        return depth;
    }
}
