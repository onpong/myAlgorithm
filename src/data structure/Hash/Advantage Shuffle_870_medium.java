//O(NlogN)//排序所花时间
//O(N)
class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        HashMap<Integer,List<Integer>> hash = new HashMap<>();
        for(int i = 0;i < nums2.length;i++){
            if(!hash.containsKey(nums2[i])){
                List<Integer> list = new ArrayList<>();
                list.add(i);
                hash.put(nums2[i],list);
            }else{
                hash.get(nums2[i]).add(i);
            }
        }
        Arrays.sort(nums2);
        int[] res = new int[nums1.length];
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i < nums2.length && j < nums1.length;){
            if(nums1[j] > nums2[i]){
                if(hash.get(nums2[i]).size() > 1){
                    res[hash.get(nums2[i]).get(0)] = nums1[j++];
                    hash.get(nums2[i]).remove(0);
                }else{
                    res[hash.get(nums2[i]).get(0)] = nums1[j++];
                }
                i++;
            }else{
                stack.push(nums1[j++]);
            }
        }
        int r = nums2.length - 1;
        while(!stack.isEmpty()){
            int temp = stack.pop();
            if(hash.get(nums2[r]).size() > 1){
                res[hash.get(nums2[r]).get(0)] = temp;
                hash.get(nums2[r]).remove(0);
            }else{
                res[hash.get(nums2[r]).get(0)] = temp;
            }
            r--;
            
        }
        return res;
    }
}