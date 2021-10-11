class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i < nums.length;i++){
            int index = (nums[i] - 1) % nums.length;
            nums[index] += nums.length;
        }
        for(int i = 0;i < nums.length;i++){
            if(nums[i] <= nums.length){
                res.add(i + 1);
            }
        }
        return res;
    }
}