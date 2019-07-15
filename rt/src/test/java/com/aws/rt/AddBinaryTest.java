package com.aws.rt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class AddBinaryTest {
    private static AddBinary s = new AddBinary();
    private String a;
    private String b;
    private String ret;


    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {"11", "1", "100"},
                {"1010", "1011", "10101"},
        });
    }

    public AddBinaryTest(String a, String b, String ret){
        this.a = a;
        this.b = b;
        this.ret = ret;
    }

    @Test
    public void addBinaryTest(){
        assertEquals(ret, s.addBinary(a, b));
    }
}
