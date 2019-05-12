package com.aws.rt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class RemoveDuplicatesFromSortedArrayTest {
    private static RemoveDuplicatesFromSortedArray s = new RemoveDuplicatesFromSortedArray();
    private int[] input;
    private int result;


    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{}, 0},
                {new int[]{1,1, 2, 2, 3, 4}, 4},
        });
    }

    public RemoveDuplicatesFromSortedArrayTest(int[] input, int result){
        this.input = input;
        this.result = result;
    }

    @Test
    public void LCPTest(){
        assertEquals(result, s.removeDuplicates(input));
    }
}
