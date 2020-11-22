import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Description: 子集
 * Date: 2020-11-17
 * Time: 10:48 PM
 */
public class Subsets2 {

    public List<List<Integer>> subsets(int[] nums) {

        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums,len,0,path, res);
        return res;

    }

    private void dfs(int[] nums, int len,int begin,Deque<Integer> path,List<List<Integer>> res) {

        res.add(new ArrayList<>(path));
        for (int i = begin; i < len; i++) {
            path.addLast(nums[i]);
            dfs(nums, len, i + 1, path, res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Subsets2().subsets(new int[]{1,2,3}));
    }
}
