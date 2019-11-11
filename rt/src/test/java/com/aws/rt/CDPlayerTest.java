package com.aws.rt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CDPlayerTest {
    private static CDPlayer s = new CDPlayer();
    private String[] sArr;
    private int n;
    private int ret;


    @Parameterized.Parameters
    public static Collection data() {
        String[] sArr1 = new String[]{"BBAC"};
        String[] sArr2 = new String[]{"BACAB", "BCA"};
        String[] sArr3 = new String[]{"AAACBACBACBACBACBACBACB"};
        String[] sArr4 = new String[]{"ABCDEABDECBAECDEDACB"};
        String[] sArr5 = new String[]{"ABCABCABCABCABCABCABC", "ABCABCABCABCABCABCABC"};
        String[] sArr6 = new String[]{"AAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAAA"};
        String[] sArr7 = new String[]{"ADEF"};

        int n1 = 3;
        int n2 = 3;
        int n3 = 3;
        int n4 = 5;
        int n5 = 22;
        int n6 = 1;
        int n7 = 12;

        int ret1 = 1;
        int ret2 = 2;
        int ret3 = -1;
        int ret4 = 0;
        int ret5 = -1;
        int ret6 = 0;
        int ret7 = 0;

        return Arrays.asList(new Object[][]{
                {sArr1, n1, ret1},
                {sArr2, n2, ret2},
                {sArr3, n3, ret3},
                {sArr4, n4, ret4},
                {sArr5, n5, ret5},
                {sArr6, n6, ret6},
                {sArr7, n7, ret7},
        });
    }

    public CDPlayerTest(String[] sArr, int n, int ret) {
        this.sArr = sArr;
        this.n = n;
        this.ret = ret;
    }

    @Test
    public void isRandomTest() {
        assertEquals(ret, s.isRandom(sArr, n));
    }
}