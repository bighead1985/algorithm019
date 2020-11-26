import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * Description:
 * User: liqing@pluosi
 * Date: 2020-11-26
 * Time: 6:03 PM
 */
public class LargestValues {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> largestValues(TreeNode root) {

        List<Integer> ret = new ArrayList<Integer>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {

            List<Integer> level = new ArrayList<Integer>();

            PriorityQueue<Long> maxPQ = new PriorityQueue<>((o1, o2) -> (int) (o2 - o1));

            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                maxPQ.offer(Long.valueOf(node.val));
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(maxPQ.poll().intValue());
        }
        return ret;
    }

    public static void main(String[] args) {

        PriorityQueue<Double> maxPQ = new PriorityQueue<>((o1, o2) -> (int) (o2 - o1));

        System.out.println();


        int a = -2147483648;
        int b = 2147483647;
        int c = a-1;
        int d = b+1;
        System.out.println("-a:  "+ -a);   //-2147483648
        System.out.println("a-1: "+ c);     //2147483647
        System.out.println("b+1 " + d);     //-2147483648

    }
}
