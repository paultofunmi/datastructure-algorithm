package com.solutions;

public class MinSubArrayLength {
    
    public static int minSubArrayLen(int target, int[] nums) {
     
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        
        while(end < nums.length) {
            
            sum += nums[end];
            while(sum >= target) {
                
                min = Math.min(min, (end - start +1));
                sum -= nums[start++];                
            }
            
            end++;
        }
        
        return min;
        
    }

    public static void main(String[] args) {

        System.out.println(MinSubArrayLength.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
}
