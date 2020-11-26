/**
 * Description:买卖股票最佳时机2
 * Date: 2020-11-25
 * Time: 6:22 PM
 */
public class MaxProfit2 {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }
}
