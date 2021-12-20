package com.wp.project.test1;

import java.util.Arrays;

public class Demo2 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4, 2, 8, 9, 10, 8, 1};
        new Demo2().bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if(nums[j] > nums[j + 1]){
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
}



