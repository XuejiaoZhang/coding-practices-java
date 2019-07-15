package com.aws.rt;
/*
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 */

public class AddBinary {
    public String addBinary(String a, String b) {
        while (a.length() != b.length()) {
            if (a.length() < b.length()) {
                a = '0' + a;
            } else {
                b = '0' + b;
            }
        }

        int add_on = 0;
        int[] arr = new int[a.length()+1];
        for (int i = a.length() - 1; i >= 0; i--) {
            int ai = Integer.parseInt(String.valueOf(a.charAt(i)));
            int bi = Integer.parseInt(String.valueOf(b.charAt(i)));

            if (ai + bi + add_on == 3){
                arr[a.length() - 1 - i] = 1;
                add_on = 1;
            } else if (ai + bi + add_on == 2){
                arr[a.length() - 1 - i] = 0;
                add_on = 1;
            } else {
                arr[a.length() - 1 - i] = ai + bi + add_on;
                add_on = 0;
            }

            // for (int x=0; x<arr.length; x++) {
            //     System.out.println(arr[x]);
            // }
        }

        if (add_on == 1){
            arr[a.length()] = 1;
        } else {
            arr[a.length()] = 0;
        }

        String ret = "";
        if (arr[arr.length - 1] == 1){
            ret = "1";
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            ret += arr[i];
        }

        return ret;
    }
}
