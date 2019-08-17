package com.aws.rt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MergeSortedArrayTest {
    private static MergeSortedArray s = new MergeSortedArray();
    private int[] nums1;
    private int[] nums2;
    private int m;
    private int n;
    private int[] ret;

    @Parameterized.Parameters
    public static Collection data() {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        int m = 3;
        int n = 3;
        int[] ret= new int[]{1,2,2,3,5,6};

        return Arrays.asList(new Object[][]{
                {nums1, m, nums2, n, ret},
        });
    }

    public MergeSortedArrayTest(int[] nums1, int m, int[] nums2, int n, int[] ret){
        this.nums1 = nums1;
        this.m = m;
        this.nums2 = nums2;
        this.n = n;
        this.ret = ret;
    }

    @Test
    public void mergeTest(){
        s.merge(nums1, m, nums2, n);
        assertEquals(ret.length, nums1.length);
        for (int i = 0; i < nums1.length; i++){
            assertEquals(ret[i], nums1[i]);
        }
    }
}