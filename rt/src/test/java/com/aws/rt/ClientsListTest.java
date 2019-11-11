package com.example.topcoder;

import java.util.Arrays;
import java.util.Collection;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ClientsListTest {
	private static ClientsList s = new ClientsList();
	private String[] names;
	private String[] ret;

	@Parameterized.Parameters
	public static Collection data() {
		String[] names1 = new String[]{"Joe Smith", "Brown, Sam", "Miller, Judi"};
		String[] ret1 = new String[]{ "Sam Brown", "Judi Miller", "Joe Smith" };

		String[] names2 = new String[]{"Campbell, Phil", "John Campbell", "Young, Warren"};
		String[] ret2 = new String[]{ "John Campbell", "Phil Campbell", "Warren Young" };

		String[] names3 = new String[]{"Kelly, Anthony", "Kelly Anthony", "Thompson, Jack"};
		String[] ret3 = new String[]{ "Kelly Anthony", "Anthony Kelly", "Jack Thompson" };

		String[] names4 = new String[]{"Trevor Alvarez", "Jackson, Walter", "Mandi Stuart", "Martin, Michael", "Peters, Tammy", "Richard Belmont", "Carl Thomas", "Ashton, Roger", "Jamie Martin"};
		String[] ret4 = new String[]{ "Trevor Alvarez", "Roger Ashton", "Richard Belmont", "Walter Jackson", "Jamie Martin", "Michael Martin", "Tammy Peters", "Mandi Stuart", "Carl Thomas" };

		String[] names5 = new String[]{"Banks, Cody", "Cody Banks", "Tod Wilson"};
		String[] ret5 = new String[]{ "Cody Banks", "Cody Banks", "Tod Wilson" };

		String[] names6 = new String[]{"Mill, Steve", "Miller, Jane"};
		String[] ret6 = new String[]{ "Steve Mill", "Jane Miller" };



		return Arrays.asList(new Object[][]{
				{names1, ret1},
				{names2, ret2},
				{names3, ret3},
				{names4, ret4},
				{names5, ret5},
				{names6, ret6},
		});
	}

	public ClientsListTest(String[] names, String[] ret) {
		this.names = names;
		this.ret = ret;
	}

	@Test
	public void dataCleanupTest() {
		assertEquals(ret, s.dataCleanup(names));
	}
}
