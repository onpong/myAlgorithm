class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        if(nums.length == 1)
            return nums[0];
        if(nums[0] != nums[1])
            return nums[0];
        if(nums[nums.length - 1] != nums[nums.length - 2])
            return nums[nums.length - 1];
        while(low <= high){
            int medium = low + (high - low) / 2;
            if(nums[medium] != nums[medium - 1] && nums[medium] != nums[medium + 1]){
                return nums[medium];
            }else if(nums[medium] == nums[medium - 1]){
                int left = medium - 1 - low;
                int right = high - medium;
                if(left % 2 != 0)
                    high = medium - 2;
                else
                    low = medium + 1;
            }else{
                int left = medium - low;
                int right = high - 1 - medium;
                if(left % 2 != 0)
                    high = medium - 1;
                else
                    low = medium + 2;
            }
        }
       return -1;
}
}




 
