package leetcode.simple.binarytree;

import java.util.*;

/**
 * Description: 113. 路径总和 II
 * 解法1：递归解法
 * User: liqing@pluosi
 * Date: 2021-02-07
 * Time: 9:35 PM
 */
public class PathSumI {

    List<List<Integer>> ret = new LinkedList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return ret;
    }

    public void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            ret.add(new LinkedList<>(path));
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
        path.removeLast();
    }

}
