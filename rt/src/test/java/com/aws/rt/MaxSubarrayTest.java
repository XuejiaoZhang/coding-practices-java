package com.aws.rt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MaxSubarrayTest {
    private static MaxSubarray s = new MaxSubarray();
    private int[] nums;
    private int max;


    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{-2,1,-3,4,-1,2,1,-5,4}, 6},
        });
    }

    public MaxSubarrayTest(int[] nums, int max){
        this.nums = nums;
        this.max = max;
    }

    @Test
    public void maxSubArrayTest(){
        assertEquals(max, s.maxSubArray(nums));
    }
}
