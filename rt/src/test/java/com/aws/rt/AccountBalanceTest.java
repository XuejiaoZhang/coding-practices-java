package com.aws.rt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

// https://arena.topcoder.com/#/u/practiceCode/1612/5572/6036/2/1612
// TopCoder AccountBalance

//Problem Statement
//        You are working for the financial institution TopBank, and you have been tasked with writing a module that will take an initial account balance, along with a list of that day's transactions, and return the ending balance for the day.
//
//        Each transaction will be either a credit, which adds funds to the account, or a debit, which removes funds from the account. If a debit exceeds the available funds at the time, then the account balance will go negative. You will be given an startingBalance, the initial account balance. You will also be given a transactions, the list of transactions for the day. Each element of transactions will be in the form "type amount" (quotes added for clarity). Each type will be 'C' or 'D', for credit or debit, respectively. Each amount will be an integer between 1 and 1000000, inclusive, with no leading zeros. You are to return an representing the ending balance after processing all of the transactions.
//
//Definition
//        Class: AccountBalance
//        Method: processTransactions
//        Parameters: int, String[]
//        Returns: int
//        Method signature: int processTransactions(int startingBalance, String[] transactions)
//        (be sure your method is public)
//Limits
//        Time limit (s): 840.000
//        Memory limit (MB): 64

@RunWith(Parameterized.class)
public class AccountBalanceTest {
    private static AccountBalance s = new AccountBalance();
    private int in;
    private String[] trans;
    private int out;


    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {100, new String[]{"C 1000", "D 500", "D 350"}, 250},
                {100, new String[]{}, 100},
                {100, new String[]{"D 50", "D 20", "D 40"}, -10},
                {53874, new String[]{"D 1234", "C 987", "D 2345", "C 654", "D 6789", "D 34567"}, 10580},
        });
    }

    public AccountBalanceTest(int in, String[] trans, int out){
        this.in = in;
        this.trans = trans;
        this.out = out;
    }

    @Test
    public void LCPTest(){
        assertEquals(out, s.processTransactions(in, trans));
    }
}
