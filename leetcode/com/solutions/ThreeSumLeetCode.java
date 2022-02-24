package com.solutions;

import java.util.*;

/**
 * WIP
 */

public class ThreeSumLeetCode {
    
    public static List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        if(nums == null || nums.length == 0 || nums.length == 1 || nums.length == 2) return result;
        Set<Integer> seen1 = new HashSet<>();
        
        int target = 0 - nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            
            int tempTarget = target - nums[i];
            
            if(seen1.contains(tempTarget)) { 
                
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[0]);
                temp.add(tempTarget);
                temp.add(nums[i]);
                
                // Collections.sort(temp);

                if(result.size() == 0) result.add(temp);

                if(!result.contains(temp)) {

                    result.add(temp);
                }
            }

            seen1.add(nums[i]);
        }

        return result;   
    }

    public static void main(String[] args) {
        
        // System.out.println(
        //     ThreeSumLeetCode.threeSum(new int[]{-1, 0, 1, 2, -1, 4, 1})
        // );

        // System.out.println(
        //     ThreeSumLeetCode.threeSum(new int[]{-1,0,1,0})
        // );

        System.out.println(
            ThreeSumLeetCode.threeSum(new int[]{3,0,-2,-1,1,2})
        );
    }
}
