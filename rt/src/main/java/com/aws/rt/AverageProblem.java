package com.aws.rt;


//Problem Statement
//        You are given the results of a sociological survey containing several questions. Each participant was required to answer each question with an integer between 0 and 10, inclusive. You are given the average answer for each question, but the decimal portion of each average is truncated after the first three digits. For example, if there were three participants and their answers to a particular question were 4, 6 and 10, the average for that question would be given to you as 6.666.
//        You are given a marks. Each element of marks is a single space delimited list of numbers. Each number in marks is the average answer for a survey question. Return the minimum possible number of participants that could have taken this survey.
//        Definition
//
// Class: AverageProblem
//        Method: numberOfParticipants
//        Parameters: String[]
//        Returns: int
//        Method signature: int numberOfParticipants(String[] marks)
//        (be sure your method is public)
// Limits
//        Time limit (s): 840.000
//        Memory limit (MB): 64
// Constraints
//        - marks will contain between 1 and 50 elements, inclusive.
//        - Each element of marks will contain between 5 and 50 characters, inclusive.
//        - Each element of marks will be a single space separated list of numbers, where each number is between 0 and 10, inclusive, contains no extra leading zeroes, and contains exactly one decimal point followed by exactly 3 digits.
//        - marks will contain between 1 and 50 numbers, inclusive.
//Examples
//        0)
//        {"0.000"}
//        Returns: 1
//        There will always be at least one participant. In this case, the smallest number of participants that could have produced this result is 1.
//        1)
//        {"0.500 0.250", "0.125"}
//        Returns: 8
//        2)
//        {"0.500","0.300"}
//        Returns: 10
//        3)
//        {"0.500","0.301"}
//        Returns: 106


// Reder to andrewzta's solution https://community.topcoder.com/stat?c=problem_solution&cr=11829284&rd=10765&pm=7901

import java.util.StringTokenizer;

public class AverageProblem {
    public int numberOfParticipants(String[] marks) {
        int n = marks.length;
        int[] a = new int[n*50];
        int m = 0;

        for (int i = 0; i < n; i ++) {
            StringTokenizer st = new StringTokenizer(marks[i], " .");
            while (st.hasMoreTokens()){
                int z = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                a[m++] = z * 1000 + w;
               // System.out.printf("a[%d], %\n", m, z * 1000 + w);
            }
        }

        for (int p = 1; p <= 1000; p++){
            boolean ok = true;
            for(int i = 0; i < m; i++){
                // a[i] + 1, 由于a[i]上面已经乘了1000，这里+1其实是在小数点后 第三位也就是最后一位+1；后面的减1 ？
                int b = ((a[i] + 1) * p -1)/1000;
                // check if one element does not meet, then failed.

                System.out.printf("%d, %d, %d, %d\n", a[i], b, p, a[i]*p) ;
                if (a[i] *  p > b * 1000) {
                    ok = false;
                    break;
                }
            }

            if(ok) {
                return p;
            }
        }
        return 1000;
    }

    public static final void main(String[] args){
        AverageProblem a = new AverageProblem();
        //String[] s = new String[]{"0.000"};
        //String[] s = new String[]{"0.500 0.250", "0.125"};
        //String[] s = new String[]{"0.500","0.300"};
        String[] s = new String[]{"0.500","0.301"};
        int r = a.numberOfParticipants(s);
        System.out.printf("results: %d\n", r);
    }
}
