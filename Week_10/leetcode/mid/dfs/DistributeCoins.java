package leetcode.mid.dfs;

import leetcode.simple.binarytree.TreeNode;

/**
 * Description: 979. 在二叉树中分配硬币
 * User: liqing@pluosi
 * Date: 2021-02-17
 * Time: 12:14 PM
 */
public class DistributeCoins {

    int ans;

    public int distributeCoins(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    /**
     * 定义两个移动方向的数量:
     *
     * 1. 父节点 -> 当前节点
     * 2. 当前节点 -> 父节点
     *
     * 需要移动的金币数量（过载量）
     * @param node
     * @return
     */
    private int dfs(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int L = dfs(node.left);
        int R = dfs(node.right);

        ans += Math.abs(L) + Math.abs(R);
        return node.val + L + R - 1;

    }
}
