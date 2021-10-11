package com.wp.project.test1;

import java.util.Arrays;

public class Demo2 {
    public static void main(String[] args) {
       int[] nums = new int[]{2,3,4,2,8,9,10,8,1};
       new Demo2().mergeSort(nums,0,nums.length - 1,new int[nums.length]);
        System.out.println(Arrays.toString(nums));
    }
    public void mergeSort(int[] nums,int l, int r, int[] temp){
        if(l >= r)
            return;
        int m = l + (r - l) / 2;
        int left = l;
        int right = m + 1;
        int i = l;
        mergeSort(nums,l,m,temp);
        mergeSort(nums,m + 1 ,r,temp);
        while(left <= m && right <= r){
            if(nums[left] >= nums[right]){
                temp[i++] = nums[right++];
            }else if(nums[left] < nums[right]){
                temp[i++] = nums[left++];
            }
        }
        while(left <= m){
            temp[i++] = nums[left++];
        }
        while(right <= r){
            temp[i++] = nums[right++];
        }

        for(int k = l;k <= r;k++)
            nums[k] = temp[k];
    }
}




