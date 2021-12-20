/**
 * 由于每个丑数是前面某个丑数乘以2 3 5得来的，且是之中的最小值，
 * 那么假如dp[i]由dp[a] * 2得来，说明dp[a] * 2 小于dp[b] * 3 ，dp[c] * 5
 * 那应该a++,因为dp[b] * 3 ，dp[c] * 5会产生更大的还没用过的丑数。
 */
class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0;
        int b = 0;
        int c = 0;
        for(int i = 1;i < n;i++){
            dp[i] = Math.min(Math.min(dp[a] * 2,dp[b] * 3),dp[c] * 5);
            if(dp[i] == dp[a] * 2) 
                a++;
            if(dp[i] == dp[b] * 3)
                b++;
            if(dp[i] == dp[c] * 5)
                c++;
        }
        return dp[n - 1];
    }
}