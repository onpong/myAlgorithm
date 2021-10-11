//做法一自己模仿做法二写的，当时hashMap  List都没学。
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i : nums){
            if(map.containsKey(i)){
                map.put(i,map.get(i) + 1);
            }else{
                map.put(i,1);
            }
        }
        List<Integer>[] buckets = new List[nums.length + 1];
        for(int key : map.keySet()){
            int value = map.get(key);
            if(buckets[value] == null){
                buckets[value] = new ArrayList();
            }
            buckets[value].add(key);
            
        }
        int[] res = new int[k];
        int index = 0;
        for(int i = buckets.length - 1;i > 0 && index < k;i--){
            if(buckets[i] != null){
                for(int j = 0;j < buckets[i].size();j++){
                res[index++] = buckets[i].get(j);
            }
            }
            
        }
        return res;
    }
}
//做法二，桶排序
//时间复杂度O（n），空间复杂度O(n)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 构造 HashMap。Key：nums 中的每个元素；Value：对应元素出现的次数（即频率）
        Map<Integer, Integer> store = new HashMap<>();

        for (int i : nums) {
            // 填充 HashMap
            if (store.containsKey(i)) {
                store.put(i, store.get(i) + 1);
            } else {
                store.put(i, 1);
            }
        }

        // 构造一个桶的集合（即一系列桶），桶的个数为 nums 的长度 +1，因为 buckets[0] 没有意义
        // 目的是将出现频率为 i 的数放到第 i 个桶里（即 buckets[i]）
        List<Integer>[] buckets = new List[nums.length + 1];

        for (int key : store.keySet()) {
            // 某个数在 HashMap 中的 Value 是几就会被放到第几个桶里
            int value = store.get(key); 

            if (buckets[value] == null) {
                // 如果某个桶还未放入过数字（即未初始化），则初始化其为一个数组
                buckets[value] = new ArrayList();
            }

            buckets[value].add(key); // 然后将数字放到桶中
        }

        int[] res = new int[k];
        int index = 0;

        for (int i = buckets.length - 1; i > 0; --i) {
            // 遍历每个桶
            if (buckets[i] != null) {
                // 如果桶里有数字
                for (int j = 0; j < buckets[i].size() && index < k; ++j) {
                    // 依次将桶里的数字填充进 res 数组中
                    res[index++] = buckets[i].get(j);
                }
            }
        }

        return res;
    }
}

