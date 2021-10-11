//思路：用count统计当前等差数列中元素的个数，res统计最终数量。
//通过列出几个例子归纳可得，当前等差数列的数量与上一个当差数列数量之间的关系为res = res + count - 2;
//等号左边为当前等差数列的数量，等号右边为上一个等差数列的数量。
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3){
            return 0;
        }
        int len = nums.length;
        int count = 2;
        int res = 0;
        for(int i = 2;i < len;i++){
            if(nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]){
                count += 1;
                res = res + count - 2;
            }else{
                count = 2;
            }
        }
        return res;
    }
}