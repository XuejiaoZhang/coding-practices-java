/*
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
*/

class Solution {
    public int reverse(int x) {
        String s = String.valueOf(x);
        String ret = "";
        int int_ret = 0;
        if (x<0){
            ret = s.substring(s.length() - 1);
            for (int i = s.length() - 2 ; i > 0; i-- ) {
                ret += s.substring(i,i+1);
            }
        } else {
            ret = s.substring(s.length() - 1);
            for (int i = s.length() - 2 ; i >= 0; i-- ) {
                ret += s.substring(i,i+1);
            }
            System.out.println(ret);
        }

        try {
            if (x<0){
                int_ret = 0 - Integer.parseInt(ret);
            } else {
                int_ret = Integer.parseInt(ret);
            }
            return  int_ret;
        } catch (Exception e) {
            return 0;
        }
        /*
        int int_ret = Integer.parseInt(ret);
        if  (0-Math.pow(2,31) < int_ret && int_ret < Math.pow(2,31) -1 ) {
            return  Integer.parseInt(ret);
        } else {
            return 0;
        }*/
    }
}
