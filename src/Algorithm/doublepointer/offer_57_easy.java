/**
 * O(N)
 * O(1)
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int left = 0;
        int right = nums.length - 1;
        for(int i = 0;i < nums.length;i++){
            if(nums[left] + nums[right] == target){
                res[0] = nums[left];
                res[1] = nums[right];
                return res;
            }else if(nums[left] + nums[right] < target){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }
}