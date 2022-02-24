package com.solutions;

import java.util.Arrays;

public class CoinChange {
    
    public static int findMinimum(int[] coins, int target) {

        int[] dp = new int[target + 1];
        Arrays.fill(dp, target+1);
        
        System.out.println(Arrays.toString(dp));
        return -1;
    }
    
    public static void main(String[] args) {
        
        System.out.println(CoinChange.findMinimum(new int[]{1 ,2 ,5}, 11));
    }
}