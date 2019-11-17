package com.example.topcoder;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)

public class ConcatenateNumberTest {
	private static ConcatenateNumber s = new ConcatenateNumber();
	private int number;
	private int k;
	private int ret;

	@Parameterized.Parameters
	public static Collection data() {
		int number1 = 2;
		int k1 = 9;
		int ret1 = 9;

		int number2 = 121;
		int k2 = 11;
		int ret2 = 1;

		int number3 = 1;
		int k3 = 2;
		int ret3 = -1;

		int number4 = 35;
		int k4 = 98765;
		int ret4 = 9876;

		int number5 = 1000000000;
		int k5 = 3;
		int ret5 = 3;

		return Arrays.asList(new Object[][]{
				{number1, k1, ret1},
				{number2, k2, ret2},
				{number3, k3, ret3},
				{number4, k4, ret4},
				{number5, k5, ret5},
		});
	}

	public ConcatenateNumberTest(int number, int k, int ret) {
		this.number = number;
		this.k = k;
		this.ret = ret;
	}

	@Test
	public void dataCleanupTest() {
		assertEquals(ret, s.getSmallest(number,k));
	}
}
