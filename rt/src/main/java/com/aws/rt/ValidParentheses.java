package com.aws.rt;

import java.util.HashMap;
import java.util.Map;

public class ValidParentheses {
    public boolean isValid(String s) {
        Map charMap = new HashMap();
        charMap.put("{", "}");
        charMap.put("[", "]");
        charMap.put("(", ")");

        String[] strsLeft={"{","[","("};
        String[] strsRight={"}","]",")"};

        if ( s.length()%2 != 0 ) {
            return false;
        }
        if ( s.length() == 0) {
            return true;
        }

        String s2 = s;
        for (int x = s.length()-1 ; x >= 0 ; x--) {
            System.out.print(x);

            if (isHave(strsLeft, s.substring(x, x+1)) ){
                System.out.print(charMap.get(s.substring(x, x+1)));
                Boolean match = false;
                for (int y = x; y < s2.length(); y++) {
                    if (isHave(strsRight, s2.substring(y, y+1))){
                        if ( ! charMap.get(s.substring(x, x+1)).equals(s2.substring(y, y+1))) {
                            return false;
                        } else {
                            s2 = s2.substring(0,y) + s2.substring(y+1, s2.length());
                            match = true;
                            break;
                        }
                    }
                }
                if (match.equals(false)) {
                    return false;
                }
            }
        }
        return true;
    }


    public static boolean isHave(String[] strs,String s){
        for(int i=0;i<strs.length;i++){
            if(strs[i].indexOf(s)!=-1){
                return true;
            }
        }
        return false;
    }
}
