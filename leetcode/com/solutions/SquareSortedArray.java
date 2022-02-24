package com.solutions;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class SquareSortedArray {
    
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public static int[] squareArray1(int[] arr) {

        if(arr == null || arr.length == 0 || arr.length == 1) return new int[]{-1,-1};

        int[] result = new int[arr.length];

        Queue<Integer> pQueue = new PriorityQueue<Integer>();

        for(int a: arr) {

            pQueue.add(a * a);
        }

        int counter = 0;
        while(pQueue.size() > 0) {

            result[counter++] = pQueue.poll();
        }

        return result;
    }

    //Using two pointers
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public static int[] squareArray2(int[] arr) {

        if(arr == null || arr.length == 0 || arr.length == 1) return new int[]{-1,-1};

        int[] result = new int[arr.length];

        int right = 0;
        while(right < arr.length && arr[right] < 0) right++;
        int left = right - 1;

        int resultCounter = 0;

        while(left >=0 && right < arr.length) {

            int tempLS = arr[left] * arr[left];
            int tempRightS= arr[right] * arr[right];

            if(tempLS < tempRightS) { 
                
                result[resultCounter++] = tempLS; 
                left--;

            }else if(tempLS > tempRightS) { 

                result[resultCounter++] = tempRightS; 
                right++;

            }else {

                result[resultCounter++] = tempLS; 
                left--;
            }

        }


        while(left >= 0) {

            int tempLS = arr[left] * arr[left];
            result[resultCounter++] = tempLS; 
            left--;
        }

        while(right < arr.length) {

            int tempRightS= arr[right] * arr[right];
            result[resultCounter++] = tempRightS; 
            right++;
        }

        return result;
    }

    public static void main(String[] args) {
        
        int[] arr = {-4, -3, 1, 2 ,3};
        System.out.println(
            Arrays.toString(SquareSortedArray.squareArray1(arr))
        );

        System.out.println(
            Arrays.toString(SquareSortedArray.squareArray2(arr))
        );
    }
}
