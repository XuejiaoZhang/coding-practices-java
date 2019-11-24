package com.example.topcoder;

import java.util.HashSet;

public class Util {
	public boolean isSubset(String arr1[], String arr2[])
	{
		HashSet<String> hset= new HashSet<>();

		int m = arr1.length;
		int n = arr2.length;

		// hset stores all the values of arr1
		for(int i = 0; i < m; i++)
		{
			if(!hset.contains(arr1[i]))
				hset.add(arr1[i]);
		}


		// loop to check if all elements of arr2 also
		// lies in arr1
		for(int i = 0; i < n; i++)
		{
			if(!hset.contains(arr2[i])) {
				return false;
			}
		}
		return true;
	}

}
