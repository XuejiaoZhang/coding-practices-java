package com.aws.rt;

import org.junit.Test;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;

@RunWith(Parameterized.class)
public class ValidParenthesesTest {
    private static ValidParentheses s = new ValidParentheses();
    private String input;
    private boolean result;


    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {"()", true},
                {"()[]{}", true},
                {"(]", false},
                {"([)]", false},
                {"{[]}", true},
        });
    }

    public ValidParenthesesTest(String input, boolean result){
        this.input = input;
        this.result = result;
    }

    @Test
    public void isValidTest(){
        assertEquals(result, s.isValid(input));
    }

}
