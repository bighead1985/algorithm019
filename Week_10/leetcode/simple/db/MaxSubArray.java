package leetcode.simple.db;

/**
 * Description: 53. 最大子序和
 * User: liqing@pluosi
 * Date: 2021-03-02
 * Time: 9:53 AM
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {

        int len = nums.length;

        if (len == 1) {
            return nums[0];
        }

        int[] dp = new int[len];
        dp[0] = nums[0];

        int result = dp[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1]+nums[i], nums[i]);
            if (dp[i] > result) {
                result = dp[i];
            }
        }

        return result;
    }


}
