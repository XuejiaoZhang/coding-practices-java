package com.aws.rt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LengthOfLastWordTest {
    private static LengthOfLastWord s = new LengthOfLastWord();
    private String s1;
    private int len;


    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {"HEllO WORLD", 5},
        });
    }

    public LengthOfLastWordTest(String s1, int len){
        this.s1 = s1;
        this.len = len;
    }

    @Test
    public void maxSubArrayTest(){
        assertEquals(len, s.lengthOfLastWord(s1));
    }
}
