/**
 * 动态规划
 * O(N2)
 * O(N)
 */
class Solution {
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3;i <= n;i++){
            for(int j = 2;j <= i - 1;j++){
                dp[i] = Math.max(dp[i],Math.max(j * (i - j),j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
/**
 * 贪心
 * O(N)
 * O(1)
 */
class Solution {
    public int cuttingRope(int n) {
        if(n < 4)
            return n - 1;
        int res = 1;
        while(n > 4){
            res *= 3;
            n -= 3;
        }
        return res * n;
    }
}