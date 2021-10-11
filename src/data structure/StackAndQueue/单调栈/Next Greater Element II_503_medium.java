//做法一：
//时间复杂度O(N2)
//空间复杂度O(N)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0;i < nums.length;i++){
            while(!list.isEmpty() && nums[i] > nums[list.peekLast()]){
                int temp = list.pollLast();
                res[temp] = nums[i];
            }
            list.add(i);
        }
        for(int i = 0;i < list.size();i++){
            if(nums[list.get(0)] > nums[list.get(i)]){
                res[list.get(i)] = nums[list.get(0)];
            }else{
                res[list.get(i)] = -1;
            }
            for(int j = 0;j < list.get(i);j++){
                if(nums[j] > nums[list.get(i)]){
                    res[list.get(i)] = nums[j];
                    break;
                }
            }
            //    if(!listHelp.isEmpty() && nums[listHelp.peekLast()] > nums[list.get(i)]){
            //        res[list.get(i)] = nums[listHelp.peekLast()];
            //    }else if(nums[list.peekFirst()] > nums[list.get(i)]){
            //        res[list.get(i)] = nums[list.peekFirst()];
            //    }else{
            //        res[list.get(i)] = -1;
            //    }
        }
        return res;
    }
}
//方法2
//O(N)
//O(N)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res,-1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i % n];
            }
            if(i < n){
                stack.push(i % n);
            }
        }
        return res;
    }
}