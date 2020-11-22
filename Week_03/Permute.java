import java.util.*;

/**
 * Description: 全排列 回溯算法
 * User: liqing@pluosi
 * Date: 2020-11-21
 * Time: 9:00 PM
 */
public class Permute {


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(list, nums, nums.length, new ArrayDeque<Integer>(), used);
        return list;
    }

    private void backtrack(List<List<Integer>> list, int[] nums, int k, ArrayDeque path, boolean[] used) {


        //终止条件，找到一对组合
        if (k == 0) {
            list.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            //把当前值添加到集合中
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;
                //递归调用，继续下一个分支
                backtrack(list, nums, k - 1, path, used);
                path.removeLast();
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Permute().permute(new int[]{1, 2, 3}));

    }
}
