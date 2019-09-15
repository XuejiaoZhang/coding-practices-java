package com.aws.rt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AuctionHouseTest {
    private static AuctionHouse s = new AuctionHouse();
    private String[] sList;
    private String[] sRet;

    @Parameterized.Parameters
    public static Collection data() {

        String[] sList1 = new String[]{"harry golfset 1000", "william necklace 4000", "christopher golfset 1500"};
        String[] sList2 = new String[]{};
        String[] sList3 = new String[]{"wilson racket 1000"};
        String[] sList4 = new String[]{"tom golfset 1000", "yana golfset 1100", "tom golfset 1200"};
        String[] sList5 = new String[]{"ron radio 100", "amanda book 50", "ron book 200", "ron radio 300", "aamir radio 300"};
        String[] sList6 = new String[]{"kerry gamecd 100", "kent gamecd 100"};

        String[] sRet1 = new String[]{"christopher got golfset", "william got necklace"};
        String[] sRet2 = new String[]{};
        String[] sRet3 = new String[]{"wilson got racket"};
        String[] sRet4 = new String[]{"tom got golfset"};
        String[] sRet5 = new String[]{"ron got radio", "ron got book"};
        String[] sRet6 = new String[]{"kerry got gamecd"};

        return Arrays.asList(new Object[][]{
                {sList1, sRet1},
                {sList2, sRet2},
                {sList3, sRet3},
                {sList4, sRet4},
                {sList5, sRet5},
                {sList6, sRet6},
        });
    }

    public AuctionHouseTest(String[] sList, String[] sRet) {
        this.sList = sList;
        this.sRet = sRet;
    }

    @Test
    public void getListTest() {
        // 顺序不同，但结果是一样的
        assertEquals(sRet, s.getList(sList));
    }
}