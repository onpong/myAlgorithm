/**
 * O(NLOGN)
 * O(N)
 * 主要就是在并的时候统计数量
 * 这个题目只在归并排序代码基础上改动了四个地方（返回值不算）
 */
class Solution {
    public int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];
        return merge(nums,0,nums.length - 1,temp);
    }
    public int merge(int[] num,int left,int right,int[] temp){
        if(left >= right)
            return 0;
        int mid = left + (right - left) / 2;
        int i = left;
        int j = mid + 1;
        int t = i;
        int count = 0;
        int leftCount = merge(num,left,mid,temp);//第一个改动
        int rightCount = merge(num,mid + 1,right,temp);//第二个改动
        while(i <= mid && j <= right){
            if(num[j] < num[i]){
                temp[t++] = num[j++];
                count += mid - i + 1;//第三个改动
            }else{
                temp[t++] = num[i++];
            }
        }
        while(i <= mid){
            temp[t++] = num[i++];
        }
        while(j <= right){
            temp[t++] = num[j++];
        }
        t = left;
        while(left <= right){
            num[left++] = temp[t++];
        }
        return leftCount + rightCount + count;//第四个改动
    }
}