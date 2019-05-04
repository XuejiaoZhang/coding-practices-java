package com.aws.rt;

import java.io.IOException;

class Solution {
    public String canAccess(int[] rights, int minPermission) {
        String ret = "";
        for (int i: rights) {
            if (i >= minPermission){
                ret += "A";
            } else {
                ret += "D";
            }
        }
        return ret;
    }
}

public class topcoder_AccessLevel {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        int[] rights = {34,78,9,52,11,1};
        int minPermission = 49;
        String ret = s.canAccess(rights, minPermission);
        System.out.print(ret);
    }
}