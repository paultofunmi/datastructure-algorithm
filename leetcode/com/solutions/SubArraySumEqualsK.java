package com.solutions;

public class SubArraySumEqualsK {
    
    public static int subarraySum(int[] nums, int k) {
        
        int sum = 0;
        int start = 0;
        int end = 0;
        int count = 0;
        
        while(end < nums.length) {
            
            sum += nums[end];
            
            while(sum >= k) {
                
                if(sum == k) {
                    count++;                    
                }
                
                System.out.println("count is: " + count);
                sum -= nums[start++];
                
            }
             
            
            end++;
        }
        
        return count;
    }

    public static void main(String[] args) {
        
        // System.out.println(com.solutions.SubArraySumEqualsK.subarraySum(new int[]{1, 1 ,1}, 2));
        // System.out.println(com.solutions.SubArraySumEqualsK.subarraySum(new int[]{1, 2 ,3}, 3));
        System.out.println(SubArraySumEqualsK.subarraySum(new int[]{1}, 0));
    }
}
