package com.wp.project.test1;

import java.util.Arrays;

public class Demo2 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4, 2, 8, 9, 10, 8, 1};
        new Demo2().insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for(int j = i;j > 0 && nums[j] < nums[j - 1];j--){
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
            }
        }
    }
}



