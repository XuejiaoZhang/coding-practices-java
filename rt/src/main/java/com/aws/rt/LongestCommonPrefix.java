package com.aws.rt;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }


        for (int j = 0; j < strs[0].length(); j++){
            for (int i = 1; i < strs.length; i++) {
                String ret = strs[0].substring(0,j+1);
                try{
                    if (! strs[i].substring(0,j+1).equals(ret)){
                        if (j == 0) {
                            return "";
                        } else {
                            return strs[0].substring(0,j);
                        }
                    }
                } catch (Exception e) {
                    if (j == 0) {
                        return "";
                    } else {
                        return strs[0].substring(0,j);
                    }
                }
            }
        }
        return strs[0];
    }
}
