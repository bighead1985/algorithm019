/**
 * Description:
 * Date: 2020-12-13
 * Time: 10:34 PM
 */
public class Rob {
    public int rob(int[] nums) {

        int n = nums.length;
        if (n <= 1) {
            return n == 0 ? 0 : nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[n - 1];
    }

}
