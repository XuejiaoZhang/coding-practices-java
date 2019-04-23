/*
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
Follow up:

Coud you solve it without converting the integer to a string?
*/

class Solution {
    public boolean isPalindrome(int x) {
        String s=String.valueOf(x);
        for (int i = 0; i < s.length()/2; i++) {
            if ( ! s.substring(i,i+1).equals(s.substring(s.length() -i -1, s.length() -i))){
                System.out.println(s.substring(i,i+1));
                System.out.println(s.substring(s.length() -i -1, s.length() -i));
                return false;
            }

        }
        return true;
    }
}
