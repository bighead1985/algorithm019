package leetcode.simple.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 112. 路径总和
 * User: liqing@pluosi
 * Date: 2021-02-06
 * Time: 12:24 PM
 */
public class HasPathSum {

    /**
     * dfs
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum1(root.left, sum - root.val) || hasPathSum1(root.right, sum - root.val);
    }

    /**
     * bfs
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        Queue<Integer> queueVal = new LinkedList<>();
        Queue<TreeNode> queueNode = new LinkedList<>();

        queueNode.offer(root);
        queueVal.offer(root.val);

        while (!queueNode.isEmpty()) {
            TreeNode node = queueNode.poll();
            int val = queueVal.poll();
            if (node.left == null && node.right == null) {
                if (val==sum){
                    return true;
                }
                continue;
            }

            if(node.left!=null){
                queueNode.offer(node.left);
                queueVal.offer(node.left.val+val);
            }
            if(node.right!=null){
                queueNode.offer(node.right);
                queueVal.offer(node.right.val+val);
            }
        }

        return false;
    }

}


