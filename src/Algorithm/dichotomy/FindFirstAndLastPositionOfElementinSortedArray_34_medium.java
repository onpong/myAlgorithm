//定义两个辅助函数，一个函数找左边第一个，一个函数找右边最后一个。
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0)
            return new int[]{-1,-1};
        int left = findFirst(nums, target, 0, nums.length - 1);
        int right = findLast(nums, target, 0, nums.length - 1);
        return new int[]{left,right};
    }

    public int findFirst(int[] nums, int target, int low, int high){
        while(low <= high){
            int medium = low + (high - low) / 2;
            if(nums[medium] == target)
                high = medium - 1;
            else if(nums[medium] > target){
                high = medium - 1;
            }else
                low = medium + 1;
        }
        if(low != nums.length && nums[low] == target)
            return low;
        return -1;
    }
    public int findLast(int[] nums, int target, int low, int high){
        while(low <= high){
            int medium = low + (high - low) / 2;
            if(nums[medium] == target)
                low = medium + 1;
            else if(nums[medium] > target){
                high = medium - 1;
            }else
                low = medium + 1;
        }
        if(high != -1 && nums[high] == target)
            return high;
        return -1;
    }
}