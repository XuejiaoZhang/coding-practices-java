package com.example.topcoder;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ContainerWithMostWaterTest {
	private static ContainerWithMostWater s = new ContainerWithMostWater();
	private int[] height;
	private int ret;

	@Parameterized.Parameters
	public static Collection data() {
	int[] height = new int[]{1,8,6,2,5,4,8,3,7};
	int ret1 = 49;

	return Arrays.asList(new Object[][]{
		{height, ret1},
	});
}

	public ContainerWithMostWaterTest(int[] height, int ret) {
		this.height = height;
		this.ret = ret;
	}

	@Test
	public void maxAreaTest() {
		assertEquals(ret, s.maxArea(height));
	}
}


