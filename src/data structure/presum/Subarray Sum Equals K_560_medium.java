//O(N)
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hash = new HashMap<>();
        hash.put(0,1);
        int res = 0;
        int sum = 0;
        for(int i = 0;i < nums.length;i++){
            sum += nums[i];
            if(hash.containsKey(sum - k)){
                res += hash.get(sum - k);
            }
            if(hash.containsKey(sum)){
                int temp = hash.get(sum);
                hash.put(sum,temp + 1);
            }else{
                hash.put(sum,1);
            }
        }
        return res;
    }
}