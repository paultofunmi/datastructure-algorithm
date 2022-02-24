package com.solutions;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    private Map<Integer, Integer> memo = new HashMap<>();

    public int climbStairs(int n) {
        
        memo.put(0,0);
        return computeWays2(n);
    }
    
    private int computeWays2(int n ) {

        int prev = 1;
        int current = 1;
        int temp = 0;

        for(int i = 1; i < n; i++) {
            temp = current;
            current = current + prev;
            prev = temp;
        }

        return current;
    }

    private int computeWays(int n) {
        
        int result = 0;
        if(memo.containsKey(n)) return memo.get(n);

        if(n == 1) return 1;
        if(n == 2) return 2; 
        
        int result1 = computeWays(n - 1);
        int result2 = computeWays(n - 2);
        
        result = result1 + result2;
        memo.put(n, result);
        
        return result;
    }
    public static void main(String[] args) {
        
        ClimbingStairs climbingStairs = new ClimbingStairs();
        // System.out.println(climbingStairs.climbStairs(8));
        // System.out.println(climbingStairs.climbStairs(7));
        // System.out.println(climbingStairs.climbStairs(6));
        // System.out.println(climbingStairs.climbStairs(5));
        // System.out.println(climbingStairs.climbStairs(4));
        // System.out.println(climbingStairs.climbStairs(3));
        // System.out.println(climbingStairs.climbStairs(2));
        // System.out.println(climbingStairs.climbStairs(1));
        // System.out.println(climbingStairs.climbStairs(0));

        System.out.println(climbingStairs.climbStairs(4));
        System.out.println(climbingStairs.climbStairs(3));
    }
}
