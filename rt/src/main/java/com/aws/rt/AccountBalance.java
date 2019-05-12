package com.aws.rt;

//

public class AccountBalance {
    public int processTransactions(int startingBalance, String[] transactions){
        int ret = startingBalance;
        for (String tran: transactions) {
            String[] tranArr = tran.split(" ");
            String type = tranArr[0];
            int num = Integer.parseInt(tranArr[1]);
            if (type.equals("C")) {
                num = num;
            }
            if (type.equals("D")) {
                num = 0 - num;
            }
            startingBalance += num;
        }
        return startingBalance;
    }
}
