package com.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/ (121)
 */
public class BestTimetoBuyandSellStock {

    public static int maxProfit(int[] prices) {

        int result = 0;
        int low = Integer.MAX_VALUE;

        for(int i = 0; i < prices.length; i++) {

            if(prices[i] >= low) {

                int temp = prices[i] - low;
                System.out.println(temp);
                result = Math.max(result, temp);
            }else {

                low = prices[i];
            }

        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(BestTimetoBuyandSellStock.maxProfit(new int[]{7,1,5,3,6,4}));

        Map<Integer, Integer> map = new HashMap<>();
    }
}
