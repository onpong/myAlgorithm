//做法一：
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int len = nums.length;
        for(int i = 0;i < len;i++){
            sum += nums[i];
        }
        if(sum % 2 != 0){
            return false;
        }
        boolean[][] dp = new boolean[len][sum / 2 + 1];
        for(int j = 1;j < sum / 2 + 1;j++){
            if(nums[0] == j)
                dp[0][j] = true;
        }
        for(int i = 1;i < len;i++){
            for(int j = 1;j < sum / 2 + 1;j++){
                if(nums[i] == sum / 2)
                    return true;
                if(nums[i] > j){
                    dp[i][j] = dp[i - 1][j];
                     continue;
                }    
                dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j];
            }
        }
        return dp[len - 1][sum / 2];
    }
}
//做法二：空间优化
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int len = nums.length;
        for(int i = 0;i < len;i++){
            sum += nums[i];
        }
        if(sum % 2 != 0){
            return false;
        }
        boolean[]dp = new boolean[sum / 2 + 1];
        for(int j = 1;j < sum / 2 + 1;j++){
            if(nums[0] == j)
                dp[j] = true;
        }
        for(int i = 1;i < len;i++){
            for(int j = sum / 2;j >= 0;j--){
                if(nums[i] == sum / 2)
                    return true;
                if(nums[i] > j){
                     continue;
                }    
                dp[j] = dp[j - nums[i]] || dp[j];
            }
        }
        return dp[sum / 2];
    }
}