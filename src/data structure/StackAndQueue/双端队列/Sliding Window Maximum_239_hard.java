/**
 * O(NK)
 * O(1)
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0){
            return new int[]{};
        }
        int maxIndex = -1;
        int maxVal = nums[0];
        int[] res = new int[nums.length - k + 1];
        int count = 0;
        for(int i = 0;i <= nums.length - k;i++){
                //如果最大值在窗口之内，且新加入的元素小于最大值，则最大值不变
                //如果新加入元素大于等于最大值，则最大值改变，同时更换maxIndex
                //如果最大值不在窗口之内，那么要重新遍历寻找最大值。
                if(maxIndex < i){
                    int[] temp = findMax(nums,i,i + k - 1);
                    maxVal = temp[0];
                    maxIndex = temp[1];
                }else if(nums[i + k - 1] > maxVal){
                    maxVal = nums[i + k - 1];
                    maxIndex = i + k - 1;
                }
                res[count++] = maxVal;
        }
        return res;

    }
    public int[] findMax(int[] nums,int start,int end){
        int[] res = new int[2];
        res[0] = nums[start];
        for(int i = start;i <= end;i++){
            if(nums[i] > res[0]){
                res[0] = nums[i];
                res[1] = i;
            }
        }
        return res;
    }
}

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