class Solution {
    public boolean checkPossibility(int[] nums) {
        int changeTimes = 0;
       for(int i = 1;i < nums.length;i++){
           if(i > 1 && nums[i] < nums[i - 2]){
               nums[i] = nums[i - 1];
               changeTimes++;
           }else if(nums[i] < nums[i-1]){
               nums[i - 1] = nums[i];
               changeTimes++;
           }
       }
       return changeTimes <= 1;
    }
}