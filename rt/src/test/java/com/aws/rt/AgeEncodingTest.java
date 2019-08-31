package com.aws.rt;

import com.amazonaws.services.mediaconvert.model.Output;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AgeEncodingTest {
    private static AgeEncoding s = new AgeEncoding();
    private int a;
    private String c;
    private double b;

    @Parameterized.Parameters
    public static Collection data() {

        return Arrays.asList(new Object[][]{
                {10, "00010", 10.0},
                {21, "10101", 2.0},
                {6, "10100", 1.414213562373095},
                //{16, "1", -1.0},
        });
    }

    public AgeEncodingTest(int a, String c, double b) {
        this.a = a;
        this.c = c;
        this.b = b;
    }

    @Test
    public void getRadixTest() {
        b = s.getRadix(a, c);
        int ret = 0;
        for(int i=0;i<c.length();i++){
            System.out.printf("%d, %s, %d\n", i, c.charAt(i), ret);
            if (c.charAt(i) == '1'){
                ret += Math.pow(b, c.length()-i-1);
            }
        }
        assertEquals(a, ret);
    }
}