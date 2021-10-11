//做法一：
class Solution {
    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        int[][] dp = new int[len + 1][amount + 1];
        Arrays.fill(dp[0],amount + 1);
        for(int i = 1;i < len + 1;i++){
            int value = coins[i - 1];
            for(int j = 1;j < amount + 1;j++){
                if(value > j){
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                    
                dp[i][j] = Math.min(dp[i - 1][j],dp[i][j - value] + 1);
            }
        }
        if(dp[len][amount] == amount + 1){
            return -1;
        }else{
            return dp[len][amount];
        } 
        
    }
}
//做法二：空间优化
class Solution {
    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount + 1);
        dp[0] = 0;
        for(int i = 1;i < len + 1;i++){
            int value = coins[i - 1];
            for(int j = value;j < amount + 1;j++){
                dp[j] = Math.min(dp[j],dp[j - value] + 1);
            }
        }
        if(dp[amount] == amount + 1){
            return -1;
        }else{
            return dp[amount];
        } 
        
    }
}