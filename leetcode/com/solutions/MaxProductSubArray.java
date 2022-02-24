package com.solutions;

class Solution {

    public static int maxProduct(int[] nums) {
        
        
        if(nums.length == 0 || nums == null) return 0;
        if(nums.length == 1) return nums[0];
        
        int result = nums[0];

        int currMin = 1;
        int currMax = 1;
        
        for(int n : nums) {
            
            int temp = n * currMax;
            currMax = Math.max(n * currMax, Math.max(n*currMin, n));
            currMin = Math.min(temp, Math.min(n * currMin, n));
            
            result = Math.max(currMax, Math.max(currMin, result));
        }
        
        return result;
    }

    public static void main(String[] args) {
        
        System.out.println(Solution.maxProduct(new int[]{-2, 0, -1}));
        System.out.println(Solution.maxProduct(new int[]{-2, 3, -4}));
        System.out.println(Solution.maxProduct(new int[]{-2, 3, 0, -4, -6}));
        System.out.println(Solution.maxProduct(new int[]{-2, 3, -2, 4}));

    }
}