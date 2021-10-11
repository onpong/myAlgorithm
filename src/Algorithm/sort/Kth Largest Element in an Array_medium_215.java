//做法一：时间复杂度高，因为如果数组有序那么快排很慢
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 1)
            return nums[0];
        int ans = quickSort(nums, 0, nums.length - 1, k);
        return nums[ans];
    }
    public int quickSort(int[] nums, int l, int r, int k){
        if(l >= r + 1)
            return -1;
        int left = l;
        int right = r;
        int key = nums[left];
        while(left < right){
            while(left < right && nums[right] >= key)
                right--;
            nums[left] =nums[right];
            while(left < right && nums[left] <= key)
                left++;
            nums[right] =nums[left];
        }
        nums[left] = key;
        if(left == nums.length - k){
            return left;
        }
        if(left > nums.length - k){
            int ans1 = quickSort(nums, l, left - 1, k);
            if(ans1 >= 0)
                return ans1;
        }
        if(left < nums.length - k){
            int ans2 = quickSort(nums, left + 1, r, k);
            if(ans2 >= 0)
                return ans2;
        }
        return -1;
    }


//做法二  时间复杂度低，以一个随机元素作为枢轴值
import java.util.Random;
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        int ans;
        while(left < right){
            ans = partition(nums,left,right);
            if(ans < nums.length - k){
                left = ans + 1;
            }else if(ans > nums.length - k){
                right = ans - 1;
            }else{
                return nums[ans];
            }
        }
        return nums[left];
       
    }
    public int partition(int[] nums, int l, int r){
        int left = l;
        int right = r;
        Random random = new Random();
        int randomIndex = left + 1 + random.nextInt(right - left);
        swap(nums, left, randomIndex);
        int key = nums[left];
        while(left < right){
            while(left < right && nums[right] >= key)
                right--;
            nums[left] =nums[right];
            while(left < right && nums[left] <= key)
                left++;
            nums[right] =nums[left];
        }
        nums[left] = key;
        return left;
      
    }
    public void swap(int[] nums, int left, int right){
        int temp;
        temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}