//dp[0]表示当天不偷情况下最大利润，dp[1]表示当天偷的情况下最大利润。
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int[] dp = new int[2];//不偷第一个房子
        int[] dp1 = new int[2];//不偷最后一个房子
        for(int i = 1;i < nums.length;i++){
            int lastzero = dp[0];
            int lastzero1 = dp1[0];
            dp[0] = Math.max(dp[0],dp[1]);
            dp[1] = lastzero + nums[i];
            dp1[0] = Math.max(dp1[0],dp1[1]);
            dp1[1] = lastzero1 + nums[i - 1];
        }
       return Math.max(Math.max(dp[0],dp[1]),Math.max(dp1[0],dp1[1]));
    }
}