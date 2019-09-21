package com.aws.rt;

/*

Problem Statement
A string composed of the letters 'A' and 'B' is called beautiful if it satisfies all of the following criteria:

it contains no more than countA occurences of 'A';
it contains no more than countB occurences of 'B';
each substring that contains only 'A's consists of no more than maxA characters;
each substring that contains only 'B's consists of no more than maxB characters.
Given countA, countB, maxA and maxB, return the maximum possible length of a beautiful string.

Definition
Class: BeautifulString
Method: maximumLength
Parameters: int, int, int, int
Returns: int
Method signature: int maximumLength(int countA, int countB, int maxA, int maxB)
(be sure your method is public)
Limits
Time limit (s): 840.000
Memory limit (MB): 64
Constraints
- countA will be between 0 and 1000000, inclusive.
- countB will be between 0 and 1000000, inclusive.
- maxA will be between 0 and 1000000, inclusive.
- maxB will be between 0 and 1000000, inclusive.
Examples
0)
0
0
10
10
Returns: 0
We don't have any available letters as countA=0 and countB=0, so the only beautiful string is the empty one.
1)
10
10
0
0
Returns: 0
Now we have available letters, but can't include them into the beautiful string as maxA=0 and maxB=0.
2)
3
5
1
1
Returns: 7
In this case we can't have two consecutive 'A's or 'B's, so letters in the beautiful string should alternate. If we start the string from 'A', the longest one we'll be able to get is "ABABAB". But if we start the string from 'B', we'll be able to get the longer one - "BABABAB".
3)
677578
502524
989951
504698
Returns: 1180102
Here maxA >= countA and maxB >= countB, so we can easily construct a beautiful string using all available countA+countB letters.

 */
public class BeautifulString {
    public int maximumLength(int countA, int countB, int maxA, int maxB){
        if (maxA == 0) {
            return Math.min(countB, maxB);
        }
        if (maxB == 0) {
            return Math.min(countA, maxA);
        }

        if (countA <=0 && countB <= 0){
            return 0;
        } else {
            int blockA = (countA/maxA == 0) ? countA/maxA: countA/maxA + 1;
            int blockB = (countB/maxB == 0) ? countB/maxB: countB/maxB + 1;
            if (blockA > countB + 1) {
                return (countB+1) * maxA + countB;
            }
            if (blockB > countA + 1) {
                return (countA+1) * maxB + countA;
            }
            return countA + countB;
        }

    }

    public static final void main(String[] args){
        BeautifulString b = new BeautifulString();
        int countA = 3;
        int countB = 5;
        int maxA = 1;
        int maxB = 1;
        int ret = b.maximumLength(countA, countB, maxA, maxB);
        System.out.println(ret);

    }
}
