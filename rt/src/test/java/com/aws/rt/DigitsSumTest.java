package com.example.topcoder;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DigitsSumTest {
	private static DigitsSum s = new DigitsSum();
	private int n;
	private int ret;

	@Parameterized.Parameters
	public static Collection data() {
		int n1 = 2147483647;
		int n2 = 314;
		int n3 = 213413512;
		int n4 = 999999999;
		int n5 = 6;
		int n6 = 12345;

		int r1 = 1;
		int r2 = 8;
		int r3 = 4;
		int r4 = 9;
		int r5 = 6;
		int r6 = 6;


		return Arrays.asList(new Object[][]{
				{n1, r1},
				{n2, r2},
				{n3, r3},
				{n4, r4},
				{n5, r5},
				{n6, r6},
		});
	}

	public DigitsSumTest(int n, int ret) {
		this.n = n;
		this.ret = ret;
	}

	@Test
	public void findMoviesTest() {
		Assert.assertEquals(ret, s.lastDigit(n));
	}
}
