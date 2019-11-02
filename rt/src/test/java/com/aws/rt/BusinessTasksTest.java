package com.aws.rt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BusinessTasksTest {
    private static BusinessTasks s = new BusinessTasks();
    private String[] str;
    private int n;
    private String ret;


    @Parameterized.Parameters
    public static Collection data() {
        String[] s1 = new String[]{"a","b","c","d"};
        int n1 = 2;
        String r1 = "a";

        String[] s2 = new String[]{"a","b","c","d","e"};
        int n2 = 3;
        String r2 = "d";

        String[] s3 = new String[]{"alpha","beta","gamma","delta","epsilon"};
        int n3 = 1;
        String r3 = "epsilon";

        String[] s4 = new String[]{"a","b"};
        int n4 = 1000;
        String r4 = "a";

        String[] s5 = new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t", "u","v","w","x","y","z"};
        int n5 = 17;
        String r5 = "n";

        String[] s6 = new String[]{"zlqamum","yjsrpybmq","tjllfea","fxjqzznvg","nvhekxr","am","skmazcey","piklp", "olcqvhg","dnpo","bhcfc","y","h","fj","bjeoaxglt","oafduixsz","kmtbaxu", "qgcxjbfx","my","mlhy","bt","bo","q"};
        int n6 = 9000000;
        String r6 = "fxjqzznvg";

        return Arrays.asList(new Object[][]{
                {s1, n1, r1},
                {s2, n2,  r2},
                {s3, n3, r3},
                {s4, n4,  r4},
                {s5, n5, r5},
                {s6, n6,  r6}
        });
    }

    public BusinessTasksTest(String[] str , int n, String ret) {
        this.str = str;
        this.n = n;
        this.ret = ret;
    }

    @Test
    public void getaskTest() {
        // 顺序不同，但结果是一样的
        assertEquals(ret, s.getTask(str, n));
    }
}
