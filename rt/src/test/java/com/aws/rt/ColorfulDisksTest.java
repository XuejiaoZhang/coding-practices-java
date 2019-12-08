package com.example.topcoder;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Set;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ColorfulDisksTest {
	private static ColorfulDisks s = new ColorfulDisks();
	private String[] disks;
	private String[] ret;

	@Parameterized.Parameters
	public static Collection data() {
		String[] disk1 = new String[]{"red 1", "blue 1", "green 1"};
		String[] ret1 = new String[]{"blue", "green", "red" };

		String[] disk2 = new String[] {"black 2", "white 1"};
		String[] ret2 = new String[] {};

		String[] disk3 = new String[] {"black 1", "white 1", "grey 1", "grey 2", "white 3", "black 3", "grey 3"};
		String[] ret3 = new String[]  {"grey" };

		String[] disk4 = new String[] {"red 1", "red 2", "red 3", "red 2"};
		String[] ret4 = new String[] {"red" };


		return Arrays.asList(new Object[][]{
				{disk1, ret1},
				{disk2, ret2},
				{disk3, ret3},
				{disk4, ret4},

		});
	}

	public ColorfulDisksTest(String[] disks, String[] ret) {
		this.disks = disks;
		this.ret = ret;
	}

	@Test
	public void dataCleanupTest() {
		assertEquals(ret.length, s.singleColor(disks).length);

		Set<String> set = new HashSet<String>(Arrays.asList(ret));
		for(String str: s.singleColor(disks)){

			assertEquals(true, set.contains(str));

		}
	}
}

