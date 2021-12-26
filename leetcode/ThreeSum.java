package leetcode;

import java.util.Arrays;

public class ThreeSum {
    
    /**
     * Using two pointer
     * 
     * @param arr
     * @param target
     * @return
     */
    public static int[] find(int[] arr, int target) {

        int[] result = { -1, -1, -1};

        for(int i = 0; i < arr.length; i++) {

            int currTarget = target - arr[i];
            int left = i + 1;
            int right = arr.length - 1;

            while(left < right) {

                int tempTarget = arr[left] + arr[right];

                if(tempTarget < currTarget) left++;
                else if(tempTarget > currTarget) right--;
                else return new int[]{ i, left, right};
            }

        }

        return result;
    }

    public static void main(String[] args) {
        
        int[] arr1 = {1, 2, 4, 5, 12};

        System.out.println(
            Arrays.toString(ThreeSum.find(arr1, 19))
        );
    }
}
