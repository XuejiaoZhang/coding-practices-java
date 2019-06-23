package com.aws.rt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SearchInsertPositionTest {
    private static SearchInsertPosition s = new SearchInsertPosition();
    private int[] input;
    private int val;
    private int result;


    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 5, 6}, 5, 2},
                {new int[]{1, 2, 5, 6}, 2, 1},
                {new int[]{1, 2, 5, 6}, 7, 4},
                {new int[]{1, 2, 5, 6}, 0, 0},

        });
    }

    public SearchInsertPositionTest(int[] input, int val, int result){
        this.input = input;
        this.val = val;
        this.result = result;
    }

    @Test
    public void searchInsertTest(){
        assertEquals(result, s.searchInsert(input, val));
    }
}
