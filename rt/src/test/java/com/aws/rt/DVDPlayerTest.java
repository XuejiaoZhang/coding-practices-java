package com.example.topcoder;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DVDPlayerTest {
	private static DVDPlayer s = new DVDPlayer();
	private String[] moviesWatched;
	private String[] ret;

	@Parameterized.Parameters
	public static Collection data() {
		String[] moviesWatched = new String[]{"citizenkane", "casablanca", "thegodfather"};
		String[] r = new String[]{"casablanca is inside thegodfather's case", "citizenkane is inside casablanca's case" };


		String[] moviesWatched2 = new String[]{"starwars", "empirestrikesback", "returnofthejedi", "empirestrikesback", "returnofthejedi", "phantommenace", "starwars"};
		String[] r2 = new String[]{"empirestrikesback is inside returnofthejedi's case", "phantommenace is inside empirestrikesback's case", "returnofthejedi is inside phantommenace's case" };


		String[] moviesWatched3 = new String[]{"a", "x", "a", "y", "a", "z", "a"};
		String[] r3 = new String[]{};

		return Arrays.asList(new Object[][]{
				{moviesWatched, r},
				{moviesWatched2, r2},
				{moviesWatched3, r3},
		});
	}

	public DVDPlayerTest(String[] moviesWatched, String[] ret) {
		this.moviesWatched = moviesWatched;
		this.ret = ret;
	}

	@Test
	public void findMoviesTest() {
		assertEquals(ret, s.findMovies(moviesWatched));
	}
}

