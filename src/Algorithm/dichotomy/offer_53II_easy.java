/**
 * O(logn)
 * O(1)
 * 当nums[m]==m时候，说明左边没有确实的数字，所以i = m + 1,最后跳出时变量 ii 和 jj 分别指向 “右子数组的首位元素” 和 “左子数组的末位元素” 。因此返回 ii 即可。
 */
class Solution {
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }
}

