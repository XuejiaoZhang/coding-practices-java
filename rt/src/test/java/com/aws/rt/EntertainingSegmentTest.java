package com.example.topcoder;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class EntertainingSegmentTest {

	private static EntertainingSegment s = new EntertainingSegment();
	private int[] left;
	private int[] right;
	private int k;
	private int ret;

	@Parameterized.Parameters
	public static Collection data() {
		int[] left1 = new int[]{1, 4, 3, 7};
		int[] right1 = new int[]{5, 8, 7, 10};
		int k1 = 2;
		int ret1 =  5;

		int[] left2 = new int[]{1};
		int[] right2 = new int[]{1000000000}; // out of memory
		int k2 = 1;
		int ret2 =  999999999;

		int[] left3 = new int[]{1, 3};
		int[] right3 = new int[]{3, 5};
		int k3 = 2;
		int ret3 =  0;

		int[] left4 = new int[]{1,1,4,4};
		int[] right4 = new int[]{2,2,6,6};
		int k4 = 2;
		int ret4 =  2;

		int[] left5 = new int[]{1};
		int[] right5 = new int[]{2};
		int k5 = 2;
		int ret5 =  0;


		return Arrays.asList(new Object[][]{
				{left1, right1, k1, ret1},
				{left2, right2, k2, ret2},
				{left3, right3, k3, ret3},
				{left4, right4, k4, ret4},
				{left5, right5, k5, ret5},
		});
	}

	public EntertainingSegmentTest(int[] left, int[] right, int k, int ret) {
		this.left = left;
		this.right = right;
		this.k = k;
		this.ret = ret;
	}

	@Test
	public void longestEntertainingSegmentTest() {
		Assert.assertEquals(ret, s.longestEntertainingSegment(left, right, k));
	}
}

