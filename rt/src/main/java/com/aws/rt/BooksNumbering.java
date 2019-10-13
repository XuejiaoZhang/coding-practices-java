package com.aws.rt;

/*
        Problem Statement
        A new library was founded in our city. The books were labeled 1, 2, 3, 4, etc., with no leading zeroes. A total of usedDigits digits were used to create the labels. Return the total number of books in the library, or -1 if usedDigits does not correspond to a valid solution.

        Definition
        Class: BooksNumbering
        Method: numberOfBooks
        Parameters: int
        Returns: int
        Method signature: int numberOfBooks(int usedDigits)
        (be sure your method is public)
        Limits
        Time limit (s): 840.000
        Memory limit (MB): 64

        Constraints
        - usedDigits will be between 1 and 2 * 10的9次方, inclusive.

        Examples
        0)
        11
        Returns: 10
        Each of the first 9 numbers (1-9) contain one digit. Number 10 contains 2 digits. Therefore, there's a total of 11 digits.
        1)
        10
        Returns: -1
        There is no possible solution. It takes 9 digits to label 9 books, and 11 digits to label 10 books.
        2)
        189
        Returns: 99
        3)
        192
        Returns: 100
        4)
        7
        Returns: 7
        5)
        1863927342
        Returns: 219448716
        6)
        1863927343
        Returns: -1
*/

public class BooksNumbering {
    public int numberOfBooks(int usedDigits){
        // 以下数组是分别1位数，2位数，3位数 ，，，使用的数字个数，加和 < 2 * 10的9次方
        int[] t = new int[]{(9-1+1), (99-10+1)*2, (999-100+1)*3, (9999-1000+1)*4, (99999-10000+1)*5, (999999-100000+1)*6, (9999999-1000000+1)*7, (99999999-10000000+1)*8};
        int tLen = t.length;
        int i;
        for (i = 0; i < tLen; i++){
            if (usedDigits>t[i]){
                usedDigits -= t[i];
            } else {
                break;
            }
        }
        System.out.println(usedDigits);
        System.out.println(i);

        if (usedDigits % (i+1) != 0 ){
            return -1;
        } else {
            return usedDigits / (i+1) -1 + (int)Math.pow(10, i);
        }
    }

    public static final void main(String[] args){
        BooksNumbering b = new BooksNumbering();
        int usedDigits = 189;
        int ret = b.numberOfBooks(usedDigits);
        System.out.print(ret);
    }

}
