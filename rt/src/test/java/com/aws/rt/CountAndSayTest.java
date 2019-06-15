package com.aws.rt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CountAndSayTest {
    private static CountandSay s = new CountandSay();
    private int val;
    private String result;


    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {1, "1"},
                {2, "11"},
                {3, "21"},
                {4, "1211"},
                {5, "111221"},
        });
    }

    public CountAndSayTest(int val, String result){
        this.val = val;
        this.result = result;
    }

    @Test
    public void countAndSayTest(){
        assertEquals(result, s.countAndSay(val));
    }
}
