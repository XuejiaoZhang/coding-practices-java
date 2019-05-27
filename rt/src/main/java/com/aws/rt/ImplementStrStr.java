package com.aws.rt;

//Implement strStr().
//
//        Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
//
//        Example 1:
//
//        Input: haystack = "hello", needle = "ll"
//        Output: 2
//        Example 2:
//
//        Input: haystack = "aaaaa", needle = "bba"
//        Output: -1
//        Clarification:
//
//        What should we return when needle is an empty string? This is a great question to ask during an interview.
//
//        For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        StringBuilder haystackSB = new StringBuilder(haystack);
        StringBuilder needleSB = new StringBuilder(needle);
        if ( needle.length() == 0){
            return 0;
        }
        for (int j=0; j < haystack.length(); j++) {
            if (haystackSB.substring(j, j+1).equals(needleSB.substring(0, 1))){
                if (haystack.length() - j < needle.length()) {
                    return -1;
                }
                boolean ret = true;
                for (int i=1; i < needle.length(); i++) {
                    if (haystackSB.substring(j+i, j+i+1).equals(needleSB.substring(i, i+1))) {
                        ret = true;
                    } else {
                        ret = false;
                        break;
                    }
                }

                if (ret == false){
                    continue;
                } else {
                    return j;
                }

            }
        }
        return -1;
    }
}
