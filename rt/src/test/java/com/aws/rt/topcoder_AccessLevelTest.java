package com.aws.rt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class topcoder_AccessLevelTest{
    private static Solution s = new Solution();
    private int[] rights;
    private int min;
    private String result;


    @Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{}, 2, ""},
                {new int[]{2, 4}, 2, "AA"},
                {new int[]{34,78,9,52,11,1}, 49, "DADADD"},
        });
    }

    public topcoder_AccessLevelTest(int[] rights, int min, String result){
        this.rights = rights;
        this.min = min;
        this.result = result;
    }

    @Test
    public void accessLevel(){
        assertEquals(result, s.canAccess(rights, min));
    }
}