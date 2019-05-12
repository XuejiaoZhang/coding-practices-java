package com.aws.rt;

// 26. Remove Duplicates from Sorted Array

// 用数组没出现过的的值赋值给数组


public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        } else {
            int len = 0;
            for (int i = 1;i<nums.length; i++){
                if(nums[len] == nums[i]){
                    continue;
                } else {
                    len ++;
                    nums[len] = nums[i];
                }
            }
            return len+1;
        }

    }
}
