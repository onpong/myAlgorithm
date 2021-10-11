class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int leftMul = 1;
        for(int i = 0;i < res.length;i++){
            res[i] = leftMul;
            leftMul *= nums[i];
        }
        int rightMul = 1;
        for(int i = res.length - 1;i >= 0;i--){
            res[i] *= rightMul;
            rightMul *= nums[i];
        }
        return res;
    }
}