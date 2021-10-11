//空间优化前
class Solution {
    public int maxSubArray(int[] nums) {
       int[] dp = new int[nums.length + 1];
       dp[0] = 0;
       int max = nums[0];
       for(int i = 1;i < nums.length + 1;i++){
           dp[i] = Math.max(dp[i - 1] + nums[i - 1],nums[i - 1]);
           if(dp[i] > max){
               max = dp[i];
           }
            
       }
          
       return max;
    }
}

//空间优化后
class Solution {
    public int maxSubArray(int[] nums) {
       int cur = 0;
       int max = nums[0];
       for(int i = 1;i < nums.length + 1;i++){
           cur = Math.max(cur + nums[i - 1],nums[i - 1]);
           if(cur > max){
               max = cur;
           }
            
       }
          
       return max;
    }
}
