package com.example.topcoder;

//Problem Area
//		Problem Statement
//		A long straight road goes from city A to city B. There are several radio stations along the road, and their ranges are described by the s left and right. The i-th radio station can be heard at any point on the road between left[i] and right[i] kilometers from city A, inclusive.
//
//		A segment of the road is called entertaining if at least k radio stations can be heard at all points on the segment. Return the length of the longest entertaining segment of the road. If there is no such segment, return 0.
//
//		Definition
//		Class: EntertainingSegment
//		Method: longestEntertainingSegment
//		Parameters: int[], int[], int
//		Returns: int
//		Method signature: int longestEntertainingSegment(int[] left, int[] right, int k)
//		(be sure your method is public)
//		Limits
//		Time limit (s): 840.000
//		Memory limit (MB): 64
//		Constraints
//		- left will contain between 1 and 50 elements, inclusive.
//		- left and right will contain the same number of elements.
//		- Each element of left will be between 1 and 1000000000 (109), inclusive.
//		- Each element of right will be between 1 and 1000000000 (109), inclusive.
//		- Each element of left will be strictly less than the corresponding element of right.
//		- k will be between 1 and 50, inclusive.
//		Examples
//		0)
//		{1, 4, 3, 7}
//		{5, 8, 7, 10}
//		2
//		Returns: 5
//		The longest entertaining segment here is from 3 to 8.
//		1)
//		{1}
//		{1000000000}
//		1
//		Returns: 999999999
//		2)
//		{1, 3}
//		{3, 5}
//		2
//		Returns: 0
//		There is no entertaining segment here.
//		3)
//		{1,1,4,4}
//		{2,2,6,6}
//		2
//		Returns: 2
//		The ranges of radio stations can coincide.
//		4)
//		{1}
//		{2}
//		2
//		Returns: 0
//		There are not enough radio stations to form an entertaining segment.


//		{1, 4, 3, 7}
//		{5, 8, 7, 10}
//		2
//		Returns: 5

//		(1,5) 1 1 1 1 1 0 0 0 0 0
//		(4,8) 0 0 0 1 1 1 1 1 0 0
//		(3,7) 0 0 1 1 1 1 1 0 0 0
//	   (7,10) 0 0 0 0 0 0 1 1 1 1
//		TOTAL 1 1 2 3 3 2 3 2 1 1
// >2 3--8 , 8-3 = 5

//import java.util.Arrays;
//
//public class EntertainingSegment {
//	public int longestEntertainingSegment(int[] left, int[] right, int k) {
//		int min = 1;
//		Arrays.sort(right);
//		int max = right[right.length - 1];
//
//		int len = left.length;
//
//		int[] total = new int[max + 1];
//
//		for (int i = 0; i < len; i++) {
//			for (int j = left[i]; j <= right[i]; j++) {
//				total[j] += 1;
//			}
//		}
//
//		for (int x = 0; x < max+1; x++) {
//			System.out.println(total[x]);
//		}
//
//		int  ret = 0;
//		return longerSeg(0, total, k, ret);
//
//	}
//
//
//	public int longerSeg(int start, int[] total, int k, int  ret){
//		int ind_start = start;
//		int ind_end = start;
//		for (int m = start; m < total.length; m++){
//			System.out.println(total[m]);
//			if (total[m] >= k) {
//				ind_start = m;
//				for (int n = m + 1; n < total.length; n++) {
//					if (total[n] < k) {
//						ind_end = n - 1;
//						break;
//					} else {
//						ind_end = n;
//					}
//				}
//
//				break;
//			}
//		}
//
//		System.out.println("total len:");
//		System.out.println(total.length);
//
//		int ret_cur = ind_end - ind_start;
//		System.out.println("start:");
//		System.out.println(ind_start);
//		System.out.println(ind_end);
//		System.out.println("end");
//		if (ind_end+1 >= total.length || ind_start == start){
//			return Math.max(ret_cur, ret);
//		}
//		if (ret_cur >= ret) {
//			return longerSeg(ind_end+1, total, k, ret_cur);
//		}else{
//			return longerSeg(ind_end+1, total, k, ret);
//		}
//
//	}
//
//
//	public final static void main(String[] args){
//		EntertainingSegment e = new EntertainingSegment();
////		int[] left = new int[]{1, 4, 3, 7};
////		int[] right = new int[]{5, 8, 7, 10};
////		int k = 2;
////		//int ret =  5;
//
//		int[] left = new int[]{1};
//		int[] right = new int[]{1000000000}; // out of memory
//		int k = 1;
//		//int ret =  999999999;
//
////		int[] left = new int[]{1, 3};
////		int[] right = new int[]{3, 5};
////		int k = 2;
////		//int ret =  0;
//
////		int[] left = new int[]{1,1,4,4};
////		int[] right = new int[]{2,2,6,6};
////		int k = 2;
////		//int ret =  2;
//
////		int[] left = new int[]{1};
////		int[] right = new int[]{2};
////		int k = 2;
////		//int ret =  0;
//
//		int ret = e.longestEntertainingSegment(left, right, k);
//		System.out.println(ret);
//	}
//}


import java.util.*;import java.text.*;import java.math.*;import java.util.regex.*;import java.awt.geom.*;import static java.lang.Math.*;import static java.lang.Character.*;import static java.lang.Integer.*;import static java.lang.Double.*;import static java.lang.Long.*;import static java.lang.System.*;import static java.util.Arrays.*; import java.util.*;
/// Author: Minny
class Scale {
	public TreeSet<Integer> tree = new TreeSet<Integer>();
//  TreeSet 是一个有序的集合，它的作用是提供有序的Set集合。
	public void add(int... t) {
		for (int i = 0; i < t.length; i++)
			tree.add(t[i]);
	}

	public int[] toArray() {
		int[] ret = new int[tree.size()];
		int cnt = 0;
		for (int x : tree) {
			ret[cnt++] = x;
		}
		return ret;
//			0
//			1
//			3
//			4
//			5
//			7
//			8
//			10
//			1000000001
	}
}


public class EntertainingSegment {
	private int m, n;
	public int longestEntertainingSegment(int[] left, int[] right, int k) {
		Scale scale = new Scale();
		scale.add(left);
		scale.add(right);
		scale.add(0);
		scale.add(1000000001);

		int[] a = scale.toArray();
		int[] b = new int[ a.length ];
		n = left.length;
		for (int i = 0; i < a.length-1; i++) {
//			System.out.println(a[i]);
//			0
//			1
//			3
//			4
//			5
//			7
//			8
//			10


			for (int j = 0; j < n; j++) {
				if (a[i]>=left[j] && a[i+1]<=right[j]) {
					b[i] ++;
//					System.out.println("----");
//					System.out.println(a[i] + "-" + left[j] + "-" + right[j]);
//					System.out.println(i);
//					System.out.println(b[i]);
//					System.out.println("===");
				}
			}
		}
		boolean ok = false;
		int l = 0, r =0;
		for (int i = 0; i < b.length-1; i++) {
			System.out.println(b[i]);
//			0
//			1
//			2
//			3
//			2
//			2
//			1
//			0
//			5

			System.out.printf("k:", k);
			if (b[i]>=k) {
				r = a[i+1];
				if (!ok) {
					ok = true;
					l = a[i];
				}
				ret = Math.max (ret, r-l);
				System.out.println("----");
				System.out.println(r-l);
				System.out.println("===");
			} else {
				ok = false;
			}
		}
		return ret;
	}
	private int ret;

	public final static void main(String[] args){
		EntertainingSegment e = new EntertainingSegment();
//		int[] left = new int[]{1, 4, 3, 7};
//		int[] right = new int[]{5, 8, 7, 10};
//		int k = 2;
		//int ret =  5;

//		int[] left = new int[]{1};
//		int[] right = new int[]{1000000000}; // out of memory
//		int k = 1;
		//int ret =  999999999;

		int[] left = new int[]{1, 3};
		int[] right = new int[]{3, 5};
		int k = 2;
		//int ret =  0;

//		int[] left = new int[]{1,1,4,4};
//		int[] right = new int[]{2,2,6,6};
//		int k = 2;
//		//int ret =  2;

//		int[] left = new int[]{1};
//		int[] right = new int[]{2};
//		int k = 2;
//		//int ret =  0;

		int ret = e.longestEntertainingSegment(left, right, k);
		System.out.println(ret);
	}


}