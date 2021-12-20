/**
 * O(N2)
 * O(N2)
 */
class Solution {
    public double[] dicesProbability(int n) {
        /**
        子问题的解：dp[i][j]代表投完第i个骰子，点数为j出现的次数之和。
        动态转移方程：见下面的for循环，是由第i - 1个骰子产生的结果而来。
         */
        double[][] dp = new double[n + 1][6 * n + 1];
        for(int i = 1;i <= 6;i++){
            dp[1][i] = 1.0;
        }
        for(int i = 2;i <= n;i++){
            for(int j = i;j < i * 6 + 1;j++){
                for(int k = 1;k <= 6;k++){
                    if(j - k < i - 1)
                        break;
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
        double[] ans = new double[ 5 * n + 1];
        for(int i = n;i < 6 * n + 1;i++){
            ans[i - n] = dp[n][i] / Math.pow(6,n);
        }
        return ans;
    }
}