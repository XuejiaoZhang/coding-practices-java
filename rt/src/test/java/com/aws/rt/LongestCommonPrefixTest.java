package com.aws.rt;

import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;


@RunWith(Parameterized.class)
public class LongestCommonPrefixTest {
    private static LongestCommonPrefix s = new LongestCommonPrefix();
    private String[] input;
    private String result;


    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new String[]{"flower","flow","flight"}, "fl"},
                {new String[]{"dog","racecar","car"}, ""},
        });
    }

    public LongestCommonPrefixTest(String[] input, String result){
        this.input = input;
        this.result = result;
    }

    @Test
    public void LCPTest(){
        assertEquals(result, s.longestCommonPrefix(input));
    }
}
