package leetcode.simple.db;

/**
 * Description: 70. 爬楼梯
 * User: liqing@pluosi
 * Date: 2021-03-02
 * Time: 9:23 AM
 */
public class ClimbStairs {

    public int climbStairs(int n) {

        if(n <= 2){
            return n;
        }

        int[] dp  = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;


        for(int i = 3;i<=n;i++){
            dp[i] = dp[i-1] +dp[i-2];
        }

        return dp[n];
    }
}
