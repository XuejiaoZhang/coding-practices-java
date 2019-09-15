package com.aws.rt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AverageProblemTest {
    private static AverageProblem s = new AverageProblem();
    private String[] m;
    private int r;


    @Parameterized.Parameters
    public static Collection data() {
        String[] m1 = new String[]{"0.000"};
        String[] m2 = new String[]{"0.500 0.250", "0.125"};
        String[] m3 = new String[]{"0.500","0.300"};
        String[] m4 = new String[]{"0.500","0.301"};

        int r1 = 1;
        int r2 = 8;
        int r3 = 10;
        int r4 = 106;

        return Arrays.asList(new Object[][]{
                {m1, r1},
                {m2, r2},
                {m3, r3},
                {m4, r4},
        });
    }

    public AverageProblemTest(String[] m, int r){
        this.m = m;
        this.r = r;
    }

    @Test
    public void numberOfParticipantsTest(){
            assertEquals(r, s.numberOfParticipants(m));
    }
}
