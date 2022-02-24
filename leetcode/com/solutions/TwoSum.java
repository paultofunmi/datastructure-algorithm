package com.solutions;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

//Given an array, return the indices of the numbers or -1 if no match is found
public class TwoSum {
    
    //Using two pointer
    //Time: O(n)
    //Space: O(1)
    public static int[] approach1(int[] arr, int target){

        int[] result = new int[]{-1, -1};
        if(arr == null || arr.length == 0 || arr.length == 1) return result;

        int left = 0;
        int right = arr.length - 1;
        

        while(left < right){
            
            int curr = arr[left] + arr[right];
            if( curr > target) right--;
            else if( curr < target) left++;
            else return new int[]{left, right};
        }

        return result;
    }

    //Using HashMap 
    //Time: O(n)
    //Space: O(n)
    public static int[] approach2(int[] arr, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[]{-1, -1};

        System.out.println( "1-11".equals("1-11"));
        System.out.println( "1-11".equals("1-11"));
        if(arr == null || arr.length == 0 || arr.length == 1) return result;
        
        for(int i = 0; i < arr.length; i++) {

            int val = target - arr[i];
            if(map.get(val) == null) {
                
                map.put(arr[i], i);
            }else {

                return new int[]{map.get(val), i};
            }
            
        }
        
        return result;
    }

    //Using Naive Approach, two loops
    //Time: O(n^2)
    //Space: O(1)
    public static int[] approach3(int[] arr, int target) {

        int[] result = new int[]{-1, -1};

        if(arr == null || arr.length == 0 || arr.length == 1) return result;
        
        for(int i = 0; i < arr.length; i++) {

            for(int j = i + 1; j < arr.length; j++) {
                
                if(arr[i] + arr[j] == target) return new int[]{i, j};
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        
        int[] arr1 = {2,7,11,15};
        int[] arr2 = {2,3,4};
        int[] arr3 = {1,3,5,7};

        System.out.println(Arrays.toString(TwoSum.approach1(arr1, 9)));
        System.out.println(Arrays.toString(TwoSum.approach1(arr2, 6)));
        System.out.println(Arrays.toString(TwoSum.approach1(arr3, 100)));
        System.out.println(Arrays.toString(TwoSum.approach1(new int[]{1}, 100)));
        System.out.println(Arrays.toString(TwoSum.approach1(new int[]{}, 100)));
        System.out.println(Arrays.toString(TwoSum.approach1(null, 100)));
        System.out.println(Arrays.toString(TwoSum.approach1(new int[]{3, 2 , 4}, 6)));

        // System.out.println(Arrays.toString(TwoSum.approach2(arr1, 9)));
        // System.out.println(Arrays.toString(TwoSum.approach2(arr2, 6)));
        // System.out.println(Arrays.toString(TwoSum.approach2(arr3, 100)));
        // System.out.println(Arrays.toString(TwoSum.approach2(new int[]{1}, 100)));
        // System.out.println(Arrays.toString(TwoSum.approach2(new int[]{}, 100)));
        // System.out.println(Arrays.toString(TwoSum.approach2(null, 100)));

        // System.out.println(Arrays.toString(TwoSum.approach3(arr1, 9)));
        // System.out.println(Arrays.toString(TwoSum.approach3(arr2, 6)));
        // System.out.println(Arrays.toString(TwoSum.approach3(arr3, 100)));
        // System.out.println(Arrays.toString(TwoSum.approach3(new int[]{1}, 100)));
        // System.out.println(Arrays.toString(TwoSum.approach3(new int[]{}, 100)));
        // System.out.println(Arrays.toString(TwoSum.approach3(null, 100)));

    }
}
