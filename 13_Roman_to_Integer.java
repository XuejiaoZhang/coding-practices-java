/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

Example 1:

Input: "III"
Output: 3
Example 2:

Input: "IV"
Output: 4
Example 3:

Input: "IX"
Output: 9
Example 4:

Input: "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 5:

Input: "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
*/

import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Solution {
    public int romanToInt(String s) {
        String reg = "IV|IX|XL|XC|CD|CM";
        Matcher matcher = Pattern.compile(reg).matcher(s);

        int sum = 0;
        while (matcher.find()) {
            switch (matcher.group()){
                case "IV":
                    sum += 4;
                    break;
                 case "IX":
                    sum += 9;
                    break;
                case "XL":
                    sum += 40;
                    break;
                case "XC":
                    sum += 90;
                    break;
                case "CD":
                    sum += 400;
                    break;
                case "CM":
                    sum += 900;
                    break;
            }

        }

        String[] array = s.split("IV|IX|XL|XC|CD|CM");
        for (String sub1: array) {
            for (int i = 0; i < sub1.length(); i++){
                String c = sub1.substring(i, i+1);

                switch (c){
                    case "I":
                        sum += 1;
                        break;
                    case "V":
                        sum += 5;
                        break;
                    case "X":
                        sum += 10;
                        break;
                    case "L":
                        sum += 50;
                        break;
                    case "C":
                        sum += 100;
                        break;
                    case "D":
                        sum += 500;
                        break;
                    case "M":
                        sum += 1000;
                        break;
                }
            }
        }
        return sum;
    }
}
