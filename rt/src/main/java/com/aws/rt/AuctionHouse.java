package com.aws.rt;

/*

Problem Statement
You run an auction house and you have to process the day's bids for a silent auction. In a silent auction, each person makes his bid in secret, and the highest bidder for each item wins that item. If there are multiple highest bids for an item, the earliest among them will be the winner. You are given a bids containing the day's bids in chronological order. Each element is formatted as "[name of bidder] [item] [amount bid]" (quotes and brackets for clarity).

Return a containing the winners of all the items. Each element should be formatted as "[name of bidder] got [item]" (quotes and brackets for clarity). Items should appear in the same order as they first appeared in bids. For example, if bids is {"Ron radio 100", "Amanda book 50", "Ron book 200", "Ron radio 300", "Aamir radio 300"}, Ron will win both the radio and the book. Since "radio" first appears in bids earlier than "book", the return should be ordered {"Ron got radio", "Ron got book"}.
Definition
Class: AuctionHouse
Method: getList
Parameters: String[]
Returns: String[]
Method signature: String[] getList(String[] bids)
(be sure your method is public)
Limits
Time limit (s): 840.000
Memory limit (MB): 64
Constraints
- bids will contain between 0 and 50 elements, inclusive.
- Each element of bids will be formatted as "[name of bidder] [item] [amount bid]" (quotes and brackets for clarity).
- Each element of bids will contain between 5 and 50 characters, inclusive.
- Each [name of bidder] will contain between 1 and 46 lowercase letters ('a'-'z'), inclusive.
- Each [item] will contain between 1 and 46 letters ('a'-'z'), inclusive.
- Each [amount bid] will be an integer between 0 and 1000000, inclusive, with no extra leading zeroes.
Examples
0)
{"harry golfset 1000","william necklace 4000","christopher golfset 1500"}
Returns: {"christopher got golfset", "william got necklace" }
Only william bid on the necklace, and he got it for 4000. Both harry and christopher bid on the golfset, but since christopher had the higher bid, he got it for 1500.
1)
{}
Returns: { }
No bids.
2)
{"wilson racket 1000"}
Returns: {"wilson got racket" }
3)
{"tom golfset 1000","yana golfset 1100","tom golfset 1200"}
Returns: {"tom got golfset" }
A person can bid more than once on the same item.
4)
{"ron radio 100","amanda book 50","ron book 200","ron radio 300","aamir radio 300"}
Returns: {"ron got radio", "ron got book" }
The example given in the statement.
5)
{"kerry gamecd 100","kent gamecd 100"}
Returns: {"kerry got gamecd" }
kerry's bid appears earlier in bids and hence has priority over later bids of the same amount such as kent's bid.

This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.

 */

// 11:00 - 12:00

import java.util.Map;
import java.util.HashMap;

public class AuctionHouse {

    public String[] getList(String[] sList) {

        //String[] sRet = new String[50];
        Map<String,String> map = new HashMap<String, String>();
        for(int i=0;i<sList.length;i++) {
            String[] arr = sList[i].split(" ");
            String name = arr[0];
            String item = arr[1];
            String bid = arr[2];

            if (map.containsKey(item)) {
                String value = map.get(item);
                String preBid = value.split(" ")[1];
                int bidInt = Integer.parseInt(arr[2]);
                int preBidInt = Integer.parseInt(preBid);
                if (bidInt > preBidInt) {
                    map.put(item, name + " " + bid);
                }
            } else {
                map.put(item, name + " "+ bid);
            }

        }

        int length = map.size();
        String[] sRet = new String[length];
        int index = 0;
        for(Map.Entry<String, String> entry : map.entrySet()){
            String mapKey = entry.getKey();
            String mapValue = entry.getValue();
            String name = mapValue.split(" ")[0];
            System.out.println(mapKey+":"+mapValue);
            sRet[index] = name+" got "+mapKey;
            index += 1;
        }

        return sRet;
    }



    public static final void main(String[] args){
        AuctionHouse a = new AuctionHouse();

        String[] sList = new String[]{"harry golfset 1000","william necklace 4000","christopher golfset 1500"};

        System.out.print(a.getList(sList));
    }
}
