package com.wp.project.test1;

import java.util.Arrays;

public class Demo2 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4, 2, 8, 9, 10, 8, 1};
        new Demo2().selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void selectSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            int item = i;
            for(int j = i + 1;j < nums.length;j++){
                if (nums[j] < min){
                    min = nums[j];
                    item = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[item];
            nums[item] = temp;
        }
    }
}



