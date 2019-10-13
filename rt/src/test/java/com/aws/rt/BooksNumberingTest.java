package com.aws.rt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BooksNumberingTest {
    private static BooksNumbering s = new BooksNumbering();
    private int usedDigits;
    private int ret;

    @Parameterized.Parameters
    public static Collection data() {
        int n1 = 11;
        int r1 = 10;

        int n2 = 10;
        int r2 = -1;

        int n3 = 189;
        int r3 = 99;

        int n4 = 192;
        int r4 = 100;

        int n5 = 7;
        int r5 = 7;

        int n6 = 1863927342;
        int r6 = 219448716;

        int n7 = 1863927343;
        int r7 = -1;

        return Arrays.asList(new Object[][]{
                {n1, r1},
                {n2, r2},
                {n3, r3},
                {n4, r4},
                {n5, r5},
                {n6, r6},
                {n7, r7},
        });
    }

    public BooksNumberingTest(int usedDigits, int ret) {
        this.usedDigits = usedDigits;
        this.ret = ret;
    }

    @Test
    public void numberOfBooksTest() {
        // 顺序不同，但结果是一样的
        assertEquals(ret, s.numberOfBooks(usedDigits));
    }
}
