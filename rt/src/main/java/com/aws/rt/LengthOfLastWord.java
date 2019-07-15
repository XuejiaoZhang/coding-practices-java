package com.aws.rt;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        // int len = 0;
        // for (int i=s.length()-1; i>=0; i--){
        //     if (s.charAt(i)!=' '){
        //         i += 1;
        //     } else {
        //         break;
        //     }
        // }
        // return len;

        String[] arr = s.split(" ");
        if(arr.length == 0) {
            return 0;
        }
        return arr[arr.length-1].length();
    }
}
