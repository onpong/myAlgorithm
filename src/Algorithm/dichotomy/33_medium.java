/**
 * O（logn）
 * O(1)
 */
/
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
                return mid;
            if(nums[left] <= nums[mid]){//左边有序
                if(target >= nums[left] && target <= nums[mid]){//目标值在左边
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{//右边有序
                if(target >= nums[mid] && target <= nums[right]){//目标值在右边
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}