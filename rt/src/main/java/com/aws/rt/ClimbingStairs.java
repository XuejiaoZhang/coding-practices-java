package com.aws.rt;

import java.util.HashMap;
import java.util.Map;

public class  ClimbingStairs {
    public int climbStairs(int n) {
        Map<Integer, Integer> s = new HashMap<Integer, Integer>();
        s.put(1, 1);
        s.put(2, 2);
        for (int i = 3; i < n+1; i++) {
            s.put(i, s.get(i-1) * 1 + s.get(i-2) * 1);
        }
        return s.get(n);
    }
}