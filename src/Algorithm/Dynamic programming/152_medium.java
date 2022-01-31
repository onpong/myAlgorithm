/**
 * O(N)
 * O(1)
 */
class Solution {
    public int maxProduct(int[] nums) {
        int imax = 1;
        int imin = 1;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length;i++){
            if(nums[i] < 0){
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(imax * nums[i],nums[i]);
            imin = Math.min(imin * nums[i],nums[i]);
            max = Math.max(imax,max);
        }
        return max;
    }
}