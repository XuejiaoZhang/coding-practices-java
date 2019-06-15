package com.aws.rt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class RemoveElementTest {
    private static RemoveElement s = new RemoveElement();
    private int[] input;
    private int val;
    private int result;


    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{3, 2, 2, 3}, 3, 2},
                {new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2, 5},
        });
    }

    public RemoveElementTest(int[] input, int val, int result){
        this.input = input;
        this.val = val;
        this.result = result;
    }

    @Test
    public void RMEleTest(){
        assertEquals(result, s.removeElement(input, val));
    }
}
