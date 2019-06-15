package com.aws.rt;

import java.util.Arrays;

//35. Search Insert Position
//        Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
//
//        You may assume no duplicates in the array.
//        https://leetcode.com/problems/search-insert-position/

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        Integer index = 0;
        return searchInsertIndex(nums, target, index);

    }

    public int searchInsertIndex(int[] nums, int target, int index) {
        if (nums[0]>target) {
            return index + 0;
        }
        if (nums[nums.length-1]<target) {
            return index + nums.length;
        }

        Integer mid = nums.length/2;
        if (nums[mid] == target) {
            return index + mid;
        } else if (nums[mid] > target) {
            return searchInsertIndex(Arrays.copyOfRange(nums, 0, mid), target, index);
        } else  {
            return searchInsertIndex(Arrays.copyOfRange(nums, mid+1, nums.length), target, index+mid+1);
        }

    }

}
