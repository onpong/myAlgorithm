//优化之前
class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][3];
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = -prices[0];
        for(int i = 1;i < prices.length + 1;i++){
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1]);    //不持股且不卖出
            dp[i][1] = dp[i - 1][2] + prices[i - 1];      //不持股且卖出
            dp[i][2] = Math.max(dp[i - 1][2],dp[i - 1][0] - prices[i - 1]);     //持股
        }
        return Math.max(dp[prices.length][0],dp[prices.length][1]);
    }
}

//优化之后
class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[3];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = -prices[0];
        for(int i = 1;i < prices.length + 1;i++){
            int temp = dp[0];
            dp[0] = Math.max(dp[0],dp[1]);    //不持股且不卖出
            dp[1] = dp[2] + prices[i - 1];      //不持股且卖出
            dp[2] = Math.max(dp[2],temp - prices[i - 1]);     //持股
        }
        return Math.max(dp[0],dp[1]);
    }
}
