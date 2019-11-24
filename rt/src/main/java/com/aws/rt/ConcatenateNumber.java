package com.example.topcoder;


/*

Problem Area
Problem Statement
Given a positive integer number, concatenate one or more copies of number to create an integer that is divisible by k. Do not add any leading zeroes. Return the least number of copies needed, or -1 if it is impossible.
Definition
Class: ConcatenateNumber
Method: getSmallest
Parameters: int, int
Returns: int
Method signature: int getSmallest(int number, int k)
(be sure your method is public)
Limits
Time limit (s): 840.000
Memory limit (MB): 64
Constraints
- number will be between 1 and 1,000,000,000, inclusive.
- k will be between 1 and 100,000, inclusive.
Examples
0)
2
9
Returns: 9
At least 9 copies are needed, since 222222222 is divisible by 9.
1)
121
11
Returns: 1
121 is divisible by 11.
2)
1
2
Returns: -1
You can never get an even number by concatenating only 1's.
3)
35
98765
Returns: 9876
The resulting integer could be really big.
4)
1000000000
3
Returns: 3


 */
public class ConcatenateNumber {
	public  int getSmallest(int number, int k){
//		String ns = "";
//		int ret  = 0;
//		while (true) {
//			ret += 1;
//			String n = String.valueOf(number);
//			ns += n;
//
		// parseInt 有数值最大限制
//			if (Integer.parseInt(ns) % k == 0){
//				break;
//			}
//		}

//		if (number%2 != 0 && k%2 == 0 ){
//			return -1;
//		}
//
//		int ns = 0;
//		int ret  = 0;
//		ret += 1;
//		String n = String.valueOf(number);
//		int len = n.length();
//		while (true) {
//
//			ns += number * (int)Math.pow(10,(len-1)) ;
//			if (ns % k == 0){
//				break;
//			}
//
//			len += 1;
//			ret += 1;
//
//			System.out.println(ns);
//			System.out.println(len);
//		}

//		String s = number +  "";
//		int mod = 0;
//		for (int  i = 1; i < k + 10; i++){
//			for (int  j = 0; j < s.length(); j++){
//				System.out.println("-----");
//
//				System.out.println(s);
//				mod *= 10;
//				System.out.println(mod);
//				mod += s.charAt(j)  - '0';
//				System.out.println(mod);
//				mod %= k;
//				System.out.println(mod);
//			}
//
//			if (mod  == 0){
//				return i;
//			}
//		}
//		return -1;


		// Solution refer to https://community.topcoder.com/stat?c=problem_solution&cr=21014136&rd=11124&pm=8589
		// author: muntasir_120
		boolean[] seen=new boolean[k];
		String tmp=Integer.toString(number);
		int len=tmp.length();
		long tenpow=1;
		for(int i=0;i<len;i++) {
			tenpow*=10;
		}
		System.out.println(tenpow);
		tenpow%=k;

		System.out.println(tenpow);

		long mod=number%k;
		int ctr=1;
		while(!seen[(int)mod])
		{
			// 22 = 2*10 + 2
			// 22 mod 9 = 2 mod 9 * 10 mod 9 +  2 mod 9
			System.out.println("-----");
			seen[(int)mod]=true;
			if (mod==0) return ctr;
			ctr++;
			System.out.println(mod*tenpow);
			mod=(mod*tenpow)%k;
			System.out.println(mod+number);
			mod=(mod+number)%k;
		}
		return -1;


	}

	public static final void main(String[] args){
//		int number = 2;
//		int k = 9;

//		int number = 121;
//		int k = 11;

//		int number = 1;
//		int k = 2;

//		int number = 35;
//		int k = 98765;

		int number = 1000000000;
		int k = 3;

		ConcatenateNumber c = new ConcatenateNumber();
		int ret = c.getSmallest(number, k);
		System.out.println(ret);
	}
}

