package leetcode.simple.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description: 113. 路径总和 II
 * 解法2： bfs遍历
 * User: liqing@pluosi
 * Date: 2021-02-07
 * Time: 9:35 PM
 */
public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        //如果节点为空直接返回
        if (root == null) {
            return res;
        }
        //使用两个队列，一个存储结点，一个存储从根结点到当前节点的路径
        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<List<Integer>> queueList = new LinkedList<>();
        //根节点入队
        queueNode.add(root);
        //根节点的路径入队
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        queueList.add(list);

        while (!queueNode.isEmpty()) {
            //当前节点出队
            TreeNode node = queueNode.poll();

            //当前节点的路径出队
            List<Integer> tempList = queueList.poll();
            if (node.left == null && node.right == null && node.val == sum) {
                //如果满足条件，就把路径存储到res中
                res.add(tempList);
            }

            //左子节点不为空，左子节点和路径入队
            if (node.left != null) {
                tempList.add(node.left.val);
                queueList.add(new ArrayList<>(tempList));
                node.left.val += node.val;
                queueNode.add(node.left);
                tempList.remove(tempList.size() - 1);
            }

            //右子节点不为空，右子节点和路径入队
            if (node.right != null) {
                tempList.add(node.right.val);
                queueList.add(new ArrayList<>(tempList));
                node.right.val += node.val;
                queueNode.add(node.right);
                tempList.remove(tempList.size() - 1);
            }
        }
        return res;
    }
}
