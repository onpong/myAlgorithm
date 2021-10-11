//未空间优化
class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices.length == 0)
            return 0;
        int[][][] dp = new int[prices.length + 1][k + 1][2];
        if(k >= prices.length){//有利润就卖         
            return greedy(prices);
        }
        for(int j = 0;j < k + 1;j++){
            dp[0][j][0] = 0;
            dp[0][j][1] = -1001;
        }
        for(int j = 0;j < prices.length + 1;j++){
            dp[j][0][0] = 0;
            dp[j][0][1] = -1001;
        }
        for(int i = 1;i < prices.length + 1;i++){
            for(int j = 1;j < k + 1;j++){
                dp[i][j][0] = Math.max(dp[i - 1][j][0],dp[i - 1][j][1] + prices[i - 1]);
                dp[i][j][1] = Math.max(dp[i - 1][j - 1][0] - prices[i - 1],dp[i - 1][j][1]);
            }
        }
        return dp[prices.length][k][0];
    }
    public int greedy(int [] prices){
        int min = prices[0];
        int profit = 0;
        for(int i = 0;i < prices.length;i++){
            if(prices[i] <= min){
                min = prices[i];
            }else{
                profit += prices[i] - min;
                min = prices[i];
            }
        }
        return profit;
    }
}
//空间优化
class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices.length == 0)
            return 0;
        int[][] dp = new int[k + 1][2];
        if(k >= prices.length){//有利润就卖         
            return greedy(prices);
        }
        for(int j = 0;j < k + 1;j++){
            dp[j][0] = 0;
            dp[j][1] = -1001;
        }
        for(int i = 0;i < prices.length;i++){
            for(int j = k;j >= 1;j--){
                dp[j][0] = Math.max(dp[j][0],dp[j][1] + prices[i]);
                dp[j][1] = Math.max(dp[j - 1][0] - prices[i],dp[j][1]);
            }
        }
        return dp[k][0];
    }
    public int greedy(int [] prices){
        int min = prices[0];
        int profit = 0;
        for(int i = 0;i < prices.length;i++){
            if(prices[i] <= min){
                min = prices[i];
            }else{
                profit += prices[i] - min;
                min = prices[i];
            }
        }
        return profit;
    }
}