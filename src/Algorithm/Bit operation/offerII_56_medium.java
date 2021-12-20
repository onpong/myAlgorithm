class Solution {
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        int res = 0;
        for(int i = 0; i < nums.length;i++){
            for(int j = 31; j >= 0;j--){
                if(nums[i] == 0)
                    break;
                if((nums[i] & 1) == 1){
                    bits[j]++;
                }
                nums[i] >>= 1;
            }
        }
        for(int i = 0;i < 32;i++){//从最高位开始，所以后面要左移
             res = res<<1;
             res += bits[i] % 3;//这两步顺序不能变，否则最后一步会多左移一次
        }
        return res;
    }
}