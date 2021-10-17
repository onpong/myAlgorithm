/**
 * 利用HashSet
 * O(N)
 * O(N)
 */
class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> hash = new HashSet<>();
        // int[] repeat = new int[nums.length];
        // Arrays.fill(repeat,-1);
        for(int i = 0;i < nums.length;i++){
            if(!hash.contains(nums[i])){
                hash.add(nums[i]);
            }else{
                return nums[i];
            }
        }
        return -1;
    }
}
/**
 * 利用数组
 * O(N)
 * O(N)
 */
class Solution {
    public int findRepeatNumber(int[] nums) {
        int[] repeat = new int[nums.length];
        Arrays.fill(repeat,-1);
        for(int i = 0;i < nums.length;i++){
            if(repeat[nums[i]] == -1){
                repeat[nums[i]] = nums[i];
            }else{
                return nums[i];
            }
        }
        return -1;
    }
}
/**
 * 利用索引值原地交换
 * O(N)
 * O(1)
 */
class Solution {
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            if(nums[i] == i) {
                i++;
                continue;
            }
            if(nums[nums[i]] == nums[i]) return nums[i];
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }
}
