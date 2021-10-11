//方法一：二分法
//O(nlogn)
//O(1)
public class Solution {

    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 1;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt += 1;
                }
            }

            // 根据抽屉原理，小于等于 4 的个数如果严格大于 4 个，此时重复元素一定出现在 [1..4] 区间里
            if (cnt > mid) {
                // 重复元素位于区间 [left..mid]
                right = mid;
            } else {
                // if 分析正确了以后，else 搜索的区间就是 if 的反面区间 [mid + 1..right]
                left = mid + 1;
            }
        }
        return left;
    }
}


//方法二：链表判圈思想
//O(N)
//O(1)
class Solution {
    public int findDuplicate(int[] nums) {
      int slow = 0;
      int fast = 0;
      while(fast < nums.length){
          slow = nums[slow];
          fast = nums[nums[fast]];
          if(slow == fast)
            break;
      }
      fast = 0;
      while(fast != slow){
          slow = nums[slow];
          fast = nums[fast];
      }
      return fast;
    }
}