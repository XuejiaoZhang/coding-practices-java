package com.aws.rt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class AircraftTest {
    private static Aircraft s = new Aircraft();
    private int[] p1;
    private int[] v1;
    private int[] p2;
    private int[] v2;
    private int R;
    private String ret;

    @Parameterized.Parameters
    public static Collection data() {
        int[] p1 = new int[]{15, 50, 5};
        int[] v1 = new int[]{25, 1, 0};
        int[] p2 = new int[]{161, 102, 9};
        int[] v2 = new int[]{-10, -10, -1};
        int R = 10;

        int[] p11 = new int[]{0, 0, 0};
        int[] v11 = new int[]{2, 2, 0};
        int[] p21 = new int[]{9, 0, 5};
        int[] v21 = new int[]{-2, 2, 0};
        int R1 = 5;


        int[] p12 = new int[]{0, 0, 0};
        int[] v12 = new int[]{-2, 2, 0};
        int[] p22 = new int[]{9, 0, 5};
        int[] v22 = new int[]{2, 2, 0};
        int R2 = 5;

        return Arrays.asList(new Object[][]{
                {p1, v1, p2, v2, R, "YES"},
                {p11, v11, p21, v21, R1, "YES"},
                {p12, v12, p22, v22, R2, "NO"},

        });
    }

    public AircraftTest(int[] p1, int[] v1, int[] p2, int[] v2, int R, String ret) {
        this.p1 = p1;
        this.v1 = v1;
        this.p2 = p2;
        this.v2 = v2;
        this.R = R;
        this.ret = ret;
    }

    @Test
    public void checkAircraftTest() {
        //assertEquals(ret, s.checkAircraft(p1, v1, p2, v2, R));
        assertEquals(ret, s.checkAircraftMath(p1, v1, p2, v2, R));
    }
}

