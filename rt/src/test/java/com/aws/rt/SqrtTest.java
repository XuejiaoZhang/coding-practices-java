package com.aws.rt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class SqrtTest {
    private static Sqrt s = new Sqrt();
    private int a;
    private int b;



    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {4, 2},
                {8, 2},
        });
    }

    public SqrtTest(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Test
    public void addBinaryTest(){
        assertEquals(b, s.mySqrt(a));
    }
}