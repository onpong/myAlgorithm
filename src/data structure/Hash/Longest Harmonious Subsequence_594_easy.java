//做法1
//O(N)
//O(N)
class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer,Integer> hash = new HashMap<>();
        int res = 0;
        for(int i = 0;i < nums.length;i++){//先统计各个元素出现次数
            if(hash.containsKey(nums[i])){
                int temp = hash.get(nums[i]);
                temp++;
                hash.put(nums[i],temp);
            }else{
                hash.put(nums[i],1);
            }
        }
        Set set = hash.keySet();
        for(Object obj : set){//遍历hash若当前遍历元素有比他大1的元素。直接把两个元素出现次数相加。因为通过删除其他元素这两个元素一定可以构成连续子数组。
            int temp = (Integer)obj;
            Integer key = temp + 1;
            if(hash.containsKey(key)){
                int minTimes = hash.get((Integer)obj);
                int maxTimes = hash.get(key);
                if(minTimes + maxTimes > res)
                    res = maxTimes + minTimes;
            }
        }
        return res;
    }
}