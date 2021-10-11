//方法1
//时间复杂度O(N2)
//空间复杂度O(N)
class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer,Integer> hash = new HashMap<>();
        int max = 1;
        int resTemp = 0;
        int resMax = 0;
        int len = nums.length + 1;
        for(int i = 0;i < nums.length;i++){
            if(hash.containsKey(nums[i])){
                int value = hash.get(nums[i]);
                if(value + 1 > max){
                    max = value + 1;
                }
                hash.put(nums[i],++value);
            }else{
                hash.put(nums[i],1);
            }
        }
        List<Integer> list = new ArrayList<>();
        Set set = hash.keySet();
        for(Object i : set){
           if(max == hash.get((Integer)i)){
               list.add((Integer)i);
           }
       }
       for(int i = 0;i < list.size();i++){
           int temp = list.get(i);
           int left = 0;
           int right = nums.length - 1;
           while(left < nums.length - 1){
               if(nums[left] == temp){
                   break;
               }
               left++;
           }
           while(right > left){
               if(nums[right] == temp){
                   break;
               }
               right--;
           }
           if(right - left + 1 < len){
               len = right - left + 1;
           }
       }
       return len;

    }
}
//方法2
//O(N)
//O(N)
class Solution {
    public int findShortestSubArray(int[] nums) {
        //定义一个Map，Key为数组中的值，Value为一个数组，数组的第一个元素为Key出现的次数，第二个元素为Key第一次出现的位置，第三个元素为Key最后一次出现的位置。
        Map<Integer,int[]> map = new HashMap<Integer,int[]>();
        int n = nums.length;
        //遍历数组，将每一个元素出现的次数、第一次出现的位置、最后一次出现的位置记录下来
        for(int i = 0;i<n;i++){
            if(map.containsKey(nums[i])){
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            }else{
                map.put(nums[i],new int[]{1,i,i});
            }
        }

        int maxNum = 0;
        int minLen = 0;

        //遍历Map,寻找出现最多次数的Key,若Key出现的次数相同，则选择长度较短的。
        for(Map.Entry<Integer, int[]> entry : map.entrySet()){
            int[] temp = entry.getValue();
            if(temp[0] > maxNum){
                maxNum = temp[0];
                minLen = temp[2]-temp[1]+1;
            }else if(temp[0] == maxNum){
                if(minLen > temp[2]- temp[1]+1){
                    minLen = temp[2]-temp[1]+1;
                }
            }
        }
        return minLen;
    }
}