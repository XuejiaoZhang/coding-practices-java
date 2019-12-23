package com.example.topcoder;
//
//Problem Area
//		Problem Statement
//		Little Johnny is in the first grade and just found out about addition. He quickly learned the addition table and is becoming bored in class, so he thinks of a game. The game consists of choosing an integer and summing its digits. If the result is a single digit, the game ends. Otherwise, Johnny repeats the process on the result until he gets a single digit.
//
//		For example, if Johnny starts with the number 12345, he will add the digits 1 + 2 + 3 + 4 + 5 to get 15. The result is not a single digit, so he will repeat the process to get 1 + 5 = 6. The new result is a single digit, so the game ends.
//
//		Johnny is curious to see if his computations are correct, so he asks you what the final result is for the number n.
//		Definition
//		Class: DigitsSum
//		Method: lastDigit
//		Parameters: int
//		Returns: int
//		Method signature: int lastDigit(int n)
//		(be sure your method is public)
//		Limits
//		Time limit (s): 840.000
//		Memory limit (MB): 64
//		Constraints
//		- n will be between 0 and 2147483647, inclusive.
//		Examples
//		0)
//		12345
//		Returns: 6
//		The example in the problem statement.
//		1)
//		6
//		Returns: 6
//		In this simple example, the sum of the digits is 6, so the game ends after just one step.
//		2)
//		999999999
//		Returns: 9
//		The sum of the digits is 9 + 9 + 9 + 9 + 9 + 9 + 9 + 9 + 9 = 81. The process is repeated once more to get 8 + 1 = 9, which is a single digit.
//		3)
//		213413512
//		Returns: 4
//		4)
//		314
//		Returns: 8
//		5)
//		2147483647
//		Returns: 1

public class DigitsSum {
	public int lastDigit(int n) {
		String n_str = String.valueOf(n);
		int sum = 0;
		for(int i = 0; i < n_str.length(); i++) {
			char c = n_str.charAt(i);
			int c_init = Integer.parseInt(String.valueOf(c));
			sum  += c_init;
		}

		System.out.println(sum);

		if (sum <= 9){
			return sum;
		}
		return lastDigit(sum);
	}

	public final static void  main(String[] args){
		DigitsSum d = new DigitsSum();
		int n = 2147483647;
		//int n = 314;
		//int n = 213413512;
		//int n = 999999999;
		//int n = 6;
		//int n = 12345;

		int ret = d.lastDigit(n);
		System.out.println(ret);
	}
}
