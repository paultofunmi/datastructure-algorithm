package generic;

// https://www.youtube.com/watch?v=VM1kmLrrN4Y
public class MaximumSumSubArray {
    
    public static int maxSum(int[] arr, int size) {

        if(arr == null || arr.length < 3) return 0;

        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = 0; 
        int sum = 0;

        while(end < arr.length) {

            sum += arr[end];

            if( (end - start + 1) == size) {

                max = Math.max(sum, max);

                sum = sum - arr[start];
                start++;
            }
            
            end++;
        }

        return max;
    }

    public static void main(String[] args) {
        
        System.out.println(
            MaximumSumSubArray.maxSum(new int[]{2, 3, 4, 1, 5}, 3)
        );
    }
}
