package com.aws.rt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ImplementStrStrTest {
    private static ImplementStrStr s = new ImplementStrStr();
    private String s1;
    private String s2;
    private int result;


    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {"hello", "ll", 2},
                {"aaaaa", "bba", -1},
        });
    }

    public ImplementStrStrTest(String s1, String s2, int result){
        this.s1 = s1;
        this.s2 = s2;
        this.result = result;
    }

    @Test
    public void strStr(){
        assertEquals(result, s.strStr(s1, s2));
    }
}
