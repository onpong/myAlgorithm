/**
 * O(N)
 * O(1)
 */
class Solution {
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            if(nums[left] % 2 != 0 && nums[right] % 2 == 0){//左奇数右偶数
                left++;
                right--;
            }else if(nums[left] % 2 == 0 && nums[right] % 2 != 0){//左偶数右奇数
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }else if(nums[left] % 2 != 0 && nums[right] % 2 != 0){//都是奇数
                left++;
            }else{//都是偶数
                right--;
            }
        }
        return nums;

    }
}