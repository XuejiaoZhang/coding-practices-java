package com.aws.rt;

//38. Count and Say
//        The count-and-say sequence is the sequence of integers with the first five terms as following:
//
//        1.     1
//        2.     11
//        3.     21
//        4.     1211
//        5.     111221
//        1 is read off as "one 1" or 11.
//        11 is read off as "two 1s" or 21.
//        21 is read off as "one 2, then one 1" or 1211.
//
//        Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
//
//        Note: Each term of the sequence of integers will be represented as a string.
//
//        https://leetcode.com/problems/count-and-say/

import java.util.HashMap;
import java.util.Map;

public class CountandSay {
    public String countAndSay(int n) {
        Map<Integer, String> map30 = genMap30(n);
        return map30.get(n);
    }

    public Map<Integer, String> genMap30(int n) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "1");

        for (int i=2; i<=n; i++){
            String iValue = map.get(i-1);
            int length = iValue.length();

            char c = iValue.charAt(0);
            int count = 1;
            String iValueSay = "";

            if (1 == length) {
                iValueSay = iValueSay+count+c;
            }

            for (int offset = 1; offset < length; offset++){
                if (c == iValue.charAt(offset)){
                    count += 1;
                } else {
                    iValueSay = iValueSay+count+c;
                    c = iValue.charAt(offset);
                    count = 1;
                }
                if (offset == length - 1) {
                    iValueSay = iValueSay+count+c;
                }
            }
            map.put(i, iValueSay);
        }

        System.out.println(map);
        return map;
    }
}
