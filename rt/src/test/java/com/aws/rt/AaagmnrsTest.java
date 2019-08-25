package com.aws.rt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AaagmnrsTest {
        private static Aaagmnrs s = new Aaagmnrs();
        private String[] s1;
        private String[] s2;


        @Parameterized.Parameters
        public static Collection data() {
            String[] s11 = new String[]{"Aaagmnrs", "TopCoder", "anagrams", "Drop Cote" };
            String[] s12 = new String[]{"Aaagmnrs", "TopCoder" };
            String[] s21 = new String[]{"SnapDragon vs tomek", "savants groped monk", "Adam vents prongs ok" };
            String[] s22 = new String[]{"SnapDragon vs tomek" };
            String[] s31 = new String[]{"Radar ghost jilts Kim", "patched hers first", "DEPTH FIRST SEARCH", "DIJKSTRAS ALGORITHM" };
            String[] s32 = new String[]{"Radar ghost jilts Kim", "patched hers first" };


            return Arrays.asList(new Object[][]{
                    {s11, s12},
                    {s21, s22},
                    {s31, s32},
            });
        }

        public AaagmnrsTest(String[] s1, String[] s2){
            this.s1 = s1;
            this.s2 = s2;
        }

        @Test
        public void anagramsTest(){
            String[] ret = s.anagrams(s1);
            for( int i = 0; i < ret.length; i++){
                assertEquals(s1[i], ret[i]);
            }
        }
    }