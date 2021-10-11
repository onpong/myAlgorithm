//时间复杂度O(N)
//空间复杂度O（K）
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for(int i = 0;i < nums.length;i++){
            while(deque.size() != 0 && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }
            deque.addLast(i);
            if(deque.peekFirst() <= i - k){
                deque.pollFirst();
            }
            if(i >= k - 1){
                res[index++] = nums[deque.peekFirst()];
            }
            
        }
        return res;

     }
    
}