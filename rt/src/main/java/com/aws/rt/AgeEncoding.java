package com.aws.rt;


/*

Problem Statement
NOTE: This problem statement contains superscripts that may not display properly if viewed outside of the applet.

Your friend's birthday is approaching, and he wants his age to be written in candles on his cake. In fact, he has already placed several candles on the cake. The candles are arranged in a single row, and there are two different colors of candles. One color represents the digit '0' and the other color represents the digit '1'. You don't want to relayout the candles from scratch, so you have to determine if there's a base for which the existing candles spell out your friend's age. To simplify the task, you can choose any strictly positive base, not necessarily an integer one.

For example, if the candles are "00010" and your friend's age is 10, then the candles spell out 10 in base 10 (decimal). If the candles are "10101" and your friend's age is 21, then you can say that "10101" is 21 in base 2 (binary). If the candles are "10100" and your friend's age is 6, then the candles spell out 6 in base sqrt(2)=1.41421356237.... Note that you are not allowed to rotate the cake, so "10" cannot be read as "01".

You are given a candlesLine, where the i-th character is the digit ('0' or '1') represented by the i-th candle in the row of candles on the cake. You are also given an age, which is your friend's age. Return the positive base for which the candles represent your friend's age. If there is no such base, return -1, and if there are multiple such bases, return -2.
Definition
Class: AgeEncoding
Method: getRadix
Parameters: int, String
Returns: double
Method signature: double getRadix(int age, String candlesLine)
(be sure your method is public)
Limits
Time limit (s): 840.000
Memory limit (MB): 64
Notes
- The number anan-1...a1a0 in base B is equal to an*Bn + an-1*Bn-1 + ... + a1*B + a0.
- The returned value must have an absolute or relative error less than 1e-9.
Constraints
- age will be between 1 and 100, inclusive.
- candlesLine will contain between 1 and 50 characters, inclusive.
- Each character in candlesLine will be '0' (zero) or '1' (one).
Examples
0)
10
"00010"
Returns: 10.0   （10 = 0+0+0+X+0 ）
This is the first example from the statement: simply a decimal notation of the given age. Note that notation can have leading zeroes.
1)
21
"10101"
Returns: 2.0     (21 = Math.pow(X, 4) + Math.pow(X, 2) + Math.pow(X, 0) = 16 + 4 + 1)  ( Math.pow(X, 0)<100)
This is the second example from the statement: "10101" is a binary notation of the given age.
2)
6
"10100"
Returns: 1.414213562373095
This is the third example from the statement.
3)
21
"10111111110111101111111100111111110111111111111100"
Returns: 0.9685012944510603
4)
16
"1"
Returns: -1.0
In any base, "1" represents the age of 1, so it's impossible to get the age of 16.
5)
1
"1"
Returns: -2.0
In any base, "1" represents the age of 1.
6)
1
"001000"
Returns: 1.0
This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.

Coding Area
Save ClearCompileSubmit Run System Tests Go To

 */

// Approach: 1
// Refer to Author: sbzlyessit on Topcoder
// https://community.topcoder.com/stat?c=problem_solution&cr=22739066&rd=14147&pm=10589
public class AgeEncoding {
    public double getRadix(int age, String c) {
        char[] tmp = c.toCharArray();
        int[] line = new int[tmp.length];
        int i;
        for (i = 0; i < tmp.length; i++) {
            line[i] = tmp[i] - '0';  // why -'0'
            System.out.printf("line[%d] %s %s \n", i, line[i], tmp[i]);

        }

        System.out.printf("line[line.length - 1] %d\n", line[line.length - 1]);
        line[line.length - 1] -= age;
        if (line[line.length - 1] > 0) {
            return -1;
        }


        boolean found = false;
        for (i = 0; i < line.length - 1; i++) {
            if (line[i] != 0) {
                found = true;
            }
        }
        if (!found) {
            if (line[line.length - 1] < 0) {
                return -1;
            } else {
                return -2;
            }
        }

        if (line[line.length - 1] == 0) {
            return -1;
        }
        double x = 1.0;
        double a, b, p, delta;
        do {

            // ???

            for (a = 0.0, p = 1.0, i = line.length - 1; i >= 0; i--) {
                a += p * line[i];
                p *= x;
            }
            for (b = 0.0, p = 1.0, i = line.length - 2; i >= 0; i--) {
                b += p * line[i] * (line.length - 1 - i);
                p *= x;
            }
            delta = a / b;
            if (Math.abs(delta) < 1e-12) {
                break;
            }
            x -= delta;
        } while (true);
        return x;
    }
}


