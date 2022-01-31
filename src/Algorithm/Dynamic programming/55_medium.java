/**
 * O(N2)
 * O(N)
 */
class Solution {
    public boolean canJump(int[] nums) {
        //动态规划
        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;
        for(int i = nums.length - 2;i >= 0;i--){
            if(nums[i] + i >= nums.length - 1){
                dp[i] = true;
            }
            for(int j = i + 1;j < i + nums[i] + 1;j++){
                if(dp[j] == true){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}
/**
 * O(N)
 * O(1)
 */
class Solution{
    public static boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }
        //前n-1个元素能够跳到的最远距离
        int k = 0;
        for (int i = 0; i <= k; i++) {
            //第i个元素能够跳到的最远距离
            int temp = i + nums[i];
            //更新最远距离
            k = Math.max(k, temp);
            //如果最远距离已经大于或等于最后一个元素的下标,则说明能跳过去,退出. 减少循环
            if (k >= nums.length - 1) {
                return true;
            }
        }
        //最远距离k不再改变,且没有到末尾元素
        return false;
    }
}
