/**
 * O(N2)
 * O(1)
 */
class Solution {
    public void nextPermutation(int[] nums) {
        int start = -1;
        for(int i = nums.length - 2;i >= 0;i--){
            int index = i;
            for(int j = i + 1; j < nums.length;j++){
                //寻找比nums[i]大且是最小的数
                if(nums[j] > nums[i] && index == i){
                    index = j;
                    continue;
                }
                if(nums[j] > nums[i]){
                    index = nums[j] <= nums[index] ? j : index;   
                }
            }
            if(index > i){
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                start = i;
                break; 
            }
        }
            Arrays.sort(nums,start + 1,nums.length);
    }
}