/**
 * O(N)
 * O(1)
 */
class Solution {
    public int[] singleNumbers(int[] nums) {
        int ret = 0;
        for(int i = 0;i < nums.length;i++){
            ret ^= nums[i];
        }
        int h = 1;
        while((ret & h) == 0){//得到异或中从右往左数的第一个1
            h <<= 1;
        }   
        int[] res = new int[2];
        for(int i = 0;i < nums.length;i++){
            if((h & nums[i]) == 0){
                res[0] ^= nums[i];
            }else{
                res[1] ^= nums[i];
            }
        }
        return res;
    }
}