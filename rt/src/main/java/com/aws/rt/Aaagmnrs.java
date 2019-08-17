package com.aws.rt;

//Problem Statement
//        Two phrases are anagrams if they are permutations of each other, ignoring spaces and capitalization. For example, "Aaagmnrs" is an anagram of "anagrams", and "TopCoder" is an anagram of "Drop Cote". Given a phrases, remove each phrase that is an anagram of an earlier phrase, and return the remaining phrases in their original order.
//
//        Definition
//        Class: Aaagmnrs
//        Method: anagrams
//        Parameters: String[]
//        Returns: String[]
//        Method signature: String[] anagrams(String[] phrases)
//        (be sure your method is public)
//        Limits
//        Time limit (s): 840.000
//        Memory limit (MB): 64
//        Constraints
//        - phrases contains between 2 and 50 elements, inclusive.
//        - Each element of phrases contains between 1 and 50 characters, inclusive.
//        - Each element of phrases contains letters ('a'-'z' and 'A'-'Z') and spaces (' ') only.
//        - Each element of phrases contains at least one letter.
//        Examples
//        0)
//        { "Aaagmnrs", "TopCoder", "anagrams", "Drop Cote" }
//        Returns: { "Aaagmnrs", "TopCoder" }
//        The examples above.
//        1)
//        { "SnapDragon vs tomek", "savants groped monk", "Adam vents prongs ok" }
//        Returns: { "SnapDragon vs tomek" }
//        2)
//        { "Radar ghost jilts Kim", "patched hers first", "DEPTH FIRST SEARCH", "DIJKSTRAS ALGORITHM" }
//        Returns: { "Radar ghost jilts Kim", "patched hers first" }
//        This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Aaagmnrs {
    public String[] anagrams(String[] phrases){
        List<String> phraseslist = Arrays.asList(phrases);
        List<String> ret = new ArrayList<>();


        for (int i = 0; i < phraseslist.size()-1; i++ ) {
            for (int j = i + 1; j < phraseslist.size(); j++) {
                String si = phraseslist.get(i);
                String sj = phraseslist.get(j);
                System.out.printf("%d,%d,%s, %s\n", i, j, si, sj);

                if (sj.equals("")) {
                    continue;
                }

                if (IsAnagram(si, sj)) {
                    phraseslist.set(j, "");
                    if (!ret.contains(si)) {
                        System.out.printf("add: %s\n", si);
                        ret.add(si);
                    }
                }

            }
        }

//        for(int k = 0; k < ret.size(); k++) {
//            System.out.printf("ret:%s\n", ret.get(k));
//        }
        String[] toBeStored = ret.toArray(new String[ret.size()]);

//        for(String s: toBeStored) {
//            System.out.printf("ret sss:%s\n", s);
//        }
        return toBeStored;
    }

    static boolean IsAnagram(String sFirst, String sSecond) {
        sFirst = sFirst.replaceAll(" ","");
        sSecond = sSecond.replaceAll(" ","");

        sFirst = sFirst.toLowerCase();
        sSecond = sSecond.toLowerCase();

        char[] cFirstArray = sFirst.toCharArray();
        char[] cSecondArray = sSecond.toCharArray();

        Arrays.sort(cFirstArray);
        Arrays.sort(cSecondArray);

//        System.out.printf("cFirstArray",  cFirstArray);
//        System.out.printf("cSecondArray",  cSecondArray);
        return Arrays.equals(cFirstArray, cSecondArray);
    }

    private char charToLowerCase(char ch){
        if(ch <= 90 && ch >= 65){
            ch += 32;
        }
        return ch;
    }

    public static final void main(String[] args){
        Aaagmnrs a = new Aaagmnrs();
        //String[] s11 = new String[]{"Aaagmnrs", "TopCoder", "anagrams", "Drop Cote" };
        //String[] s11 = new String[]{"SnapDragon vs tomek", "savants groped monk", "Adam vents prongs ok" };
        String[] s11 = new String[]{"Radar ghost jilts Kim", "patched hers first", "DEPTH FIRST SEARCH", "DIJKSTRAS ALGORITHM" };

        String[] ret = a.anagrams(s11);
        for (String s: ret) {
            System.out.printf("results: %s\n", s);

        }

       // System.out.print(IsAnagram("TopCoder", "Drop Cote"));
    }
}


