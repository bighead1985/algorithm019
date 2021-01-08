package leetcode.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 两数之和
 * User: liqing@pluosi
 * Date: 2021-01-04
 * Time: 10:11 PM
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
