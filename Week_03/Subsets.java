import java.util.ArrayList;
import java.util.List;

/**
 * Description: 子集
 * Date: 2020-11-17
 * Time: 10:48 PM
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) {
            return ans;
        }
        dfs(ans, nums, new ArrayList<Integer>(), 0);
        return ans;

    }

    private void dfs(List<List<Integer>> ans, int[] nums, ArrayList<Integer> list, int index) {

        if (index == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        dfs(ans, nums, list, index + 1); //not pick the num at this index

        list.add(nums[index]);
        dfs(ans, nums, list, index + 1); //pick the num at this index

        //restore state
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{1,2,3}));
    }
}
