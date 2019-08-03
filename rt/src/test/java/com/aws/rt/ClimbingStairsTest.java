package com.aws.rt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class ClimbingStairsTest {
    private static ClimbingStairs s = new ClimbingStairs();
    private int n;
    private int m;



    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {2, 2},
                {3, 3},
        });
    }

    public ClimbingStairsTest(int n, int m){
        this.n = n;
        this.m = m;
    }

    @Test
    public void addBinaryTest(){
        assertEquals(m, s.climbStairs(n));
    }
}