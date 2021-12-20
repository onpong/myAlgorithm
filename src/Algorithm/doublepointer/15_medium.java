  /**
   *排序NLOGN + 遍历O(N2),总共O(N2)
   */
  class Solution{
  public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length < 3)
            return res;
        //排序
        Arrays.sort(nums);
        //双指针
        for(int i = 0; i < nums.length - 1;i++){
            if(i != 0 && nums[i] == nums[i - 1])
                continue;
            if(nums[i] > 0)
                return res;
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[left] + nums[right] + nums[i];
                if(sum == 0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    res.add(temp);
                    while(left < right && nums[left] == nums[left + 1])
                        left++;
                    while(left < right && nums[right] == nums[right - 1])
                        right--;
                    left++;
                    right--;
                }else if(sum < 0){
                    left++;
                }else{
                    right--;
                }
            }
        }
      return res;
    }
  }