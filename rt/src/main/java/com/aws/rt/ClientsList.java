package com.example.topcoder;

/*

Problem Area
Problem Statement
Your company has just undergone some software upgrades, and you will now be storing all of the names of your clients in a new database. Unfortunately, your existing data is inconsistent, and cannot be imported as it is. You have been tasked with writing a program to cleanse the data.

You are given a , names, which is a list of the names of all of your existing clients. Some of the names are in "First Last" format, while the rest are in "Last, First" format. You are to return a with all of the names in "First Last" format, sorted by last name, then by first name.

Definition
Class: ClientsList
Method: dataCleanup
Parameters: String[]
Returns: String[]
Method signature: String[] dataCleanup(String[] names)
(be sure your method is public)
Limits
Time limit (s): 840.000
Memory limit (MB): 64
Constraints
- names will contain between 1 and 50 elements, inclusive.
- Each element of names will be of the form "First Last" or "Last, First" (quotes added for clarity).
- Each first and last name will begin with a single capital letter 'A'-'Z', and the remaining letters will be lower case 'a'-'z'.
- Each element of names will contain between 3 and 50 characters, inclusive.
Examples
0)
{"Joe Smith", "Brown, Sam", "Miller, Judi"}
Returns: { "Sam Brown", "Judi Miller", "Joe Smith" }
The last names, in order, are Brown, Miller, Smith. We rearrange each name to be in the proper format also.
1)
{"Campbell, Phil", "John Campbell", "Young, Warren"}
Returns: { "John Campbell", "Phil Campbell", "Warren Young" }
Notice here how we sort by first name when the last names are the same.
2)
{"Kelly, Anthony", "Kelly Anthony", "Thompson, Jack"}
Returns: { "Kelly Anthony", "Anthony Kelly", "Jack Thompson" }
Be careful to properly identify first name versus last name!
3)
{"Trevor Alvarez", "Jackson, Walter", "Mandi Stuart", "Martin, Michael", "Peters, Tammy", "Richard Belmont", "Carl Thomas", "Ashton, Roger", "Jamie Martin"}
Returns: { "Trevor Alvarez", "Roger Ashton", "Richard Belmont", "Walter Jackson", "Jamie Martin", "Michael Martin", "Tammy Peters", "Mandi Stuart", "Carl Thomas" }
4)
{"Banks, Cody", "Cody Banks", "Tod Wilson"}
Returns: { "Cody Banks", "Cody Banks", "Tod Wilson" }
Notice that two identical names can appear in the list.
5)
{"Mill, Steve", "Miller, Jane"}
Returns: { "Steve Mill", "Jane Miller" }
Notice that when shorter names precede longer names alphabetically, when the shorter name is a substring of the longer.
 */

import java.util.HashMap;
import java.util.Map;

public class ClientsList {
	public String[] dataCleanup(String[] names){
		int len = names.length;
		String[] toCompare = new String[len];
		Map map = new HashMap();

		for (int i = 0;  i < len; i ++) {
			if (names[i].contains(",")) {
				String[] strArr = names[i].split(", ");
				String str = strArr[1] + " " + strArr[0];
				toCompare[i] = str;
			} else {
				toCompare[i] = names[i];
			}


		}

		String[] toCompareKey = new String[len];
		int k = 0;
		for (String str: toCompare){
			//System.out.println(str);
			String[] strArr2 = str.split(" ");
			map.put(strArr2[1]+strArr2[0], str);

			//System.out.println(strArr2[1]+strArr2[0]);
			toCompareKey[k] = strArr2[1]+strArr2[0];

			//System.out.println(toCompareKey[j]);
			k++;
		}

//		StringArraySort ss  = new StringArraySort();
//		String[] keyRet = ss.arraySort(toCompareKey);


		for (int i=0;i<toCompareKey.length-1;i++){
			for (int j=0;j<toCompareKey.length-i-1;j++) {
				if(toCompareKey[j].compareTo(toCompareKey[j+1])>0){
					String temp=toCompareKey[j];
					toCompareKey[j]=toCompareKey[j+1];
					toCompareKey[j+1]=temp;
				}
			}
		}
		String[] keyRet = toCompareKey;

		String[] toRet = new String[len];
		for (int i = 0;  i < keyRet.length; i ++) {
			//System.out.println(keyRet[i]);
			toRet[i] = (String) map.get(keyRet[i]);
		}

		return toRet;
	}


	public static final void main(String[] args) {
		ClientsList c = new ClientsList();

		String[] strArr = new String[]{"Joe Smith", "Brown, Sam", "Miller, Judi"};
		String[] ret = c.dataCleanup(strArr);
		for (int i = 0;  i < ret.length; i ++) {
			System.out.println(ret[i]);
		}

	}
}


