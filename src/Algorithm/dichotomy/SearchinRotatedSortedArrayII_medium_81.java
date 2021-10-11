//先顺序查找，找到则返回true，直到碰到后一个数比前一个数小的，那么
//从这个位置开始，在后面的区间用折半查找
class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if(nums.length == 1 && nums[0] == target)
            return true;
        else if(nums.length == 1 && nums[0] != target)
            return false;
        for(int i = 0;i < nums.length - 1;i++){
            if(nums[i] == target)
                return true;
            else if(nums[i + 1] < nums[i]){
                left = i + 1;
                break;
            }
                
        }
        while(left <= right){
            int medium = left + (right - left) / 2;
            if(nums[medium] == target)
                return true;
            else if(nums[medium] > target)
                right = medium - 1;
            else
                left = medium + 1;
        }
        return false;
    }
}

//做法2
public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[start] == nums[mid]) {
                start++;
                continue;
            }
            //前半部分有序
            if (nums[start] < nums[mid]) {
                //target在前半部分
                if (nums[mid] > target && nums[start] <= target) {
                    end = mid - 1;
                } else {  //否则，去后半部分找
                    start = mid + 1;
                }
            } else {
                //后半部分有序
                //target在后半部分
                if (nums[mid] < target && nums[end] >= target) {
                    start = mid + 1;
                } else {  //否则，去后半部分找
                    end = mid - 1;

                }
            }
        }
        //一直没找到，返回false
        return false;

    }
    