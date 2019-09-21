package com.aws.rt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BeautifulStringTest {
    private static BeautifulString s = new BeautifulString();
    private int countA;
    private int countB;
    private int maxA;
    private int maxB;
    private int ret;

    @Parameterized.Parameters
    public static Collection data() {
        int cA1 = 0;
        int cB1 = 0;
        int mA1 = 10;
        int mB1 = 10;
        int r1 = 0;

        int cA2 = 10;
        int cB2 = 10;
        int mA2 = 0;
        int mB2 = 0;
        int r2 = 0;

        int cA3 = 3;
        int cB3 = 5;
        int mA3 = 1;
        int mB3 = 1;
        int r3 = 7;

        int cA4 = 677578;
        int cB4 = 502524;
        int mA4 = 989951;
        int mB4 = 504698;
        int r4 = 1180102;


        return Arrays.asList(new Object[][]{
                {cA1, cB1, mA1, mB1, r1},
                {cA2, cB2, mA2, mB2, r2},
                {cA3, cB3, mA3, mB3, r3},
                {cA4, cB4, mA4, mB4, r4},
        });
    }

    public BeautifulStringTest(int countA, int countB, int maxA, int maxB, int ret) {
        this.countA = countA;
        this.countB = countB;
        this.maxA = maxA;
        this.maxB = maxB;
        this.ret = ret;
    }

    @Test
    public void maximumLengthTest() {
        // 顺序不同，但结果是一样的
        assertEquals(ret, s.maximumLength(countA, countB, maxA, maxB));
    }
}
