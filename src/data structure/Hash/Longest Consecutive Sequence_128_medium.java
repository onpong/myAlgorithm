class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> hash = new HashMap<>();
        if(nums.length == 0)
            return 0;
       int res = 0;
       for(int i = 0;i < nums.length;i++){
           if(!hash.containsKey(nums[i])){
               int left = hash.get(nums[i] - 1) == null ? 0 :  hash.get(nums[i] - 1);
               int right = hash.get(nums[i] + 1) == null ? 0 :  hash.get(nums[i] + 1);
               int cur = left + right + 1;
               res = Math.max(cur,res);
               hash.put(nums[i],cur);
               hash.put(nums[i] - left,cur);
               hash.put(nums[i] + right,cur);
           }
       }
       return res;
       
    }
}