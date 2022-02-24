package interviewprep.generic;

public class SizeSubArrayGreaterOrEqualTarget {
    
    public static int findSize(int[] arr, int target) {

        int min_length = -1;
        int start = 0; 
        int curr_sum = 0; 

        for(int i = 0; i < arr.length; i++) {

            curr_sum += arr[i];

            while(curr_sum >= target) {

                int tempLength = i - start + 1;

                if(min_length == -1) {

                    min_length = tempLength;

                }else {

                    min_length = Math.min(tempLength, min_length);
                }

                    curr_sum -= arr[start];
                    start++;
                }
            }    

        return min_length;
    }
    public static void main(String[] args) {
        
        System.out.println(
            SizeSubArrayGreaterOrEqualTarget.findSize(
                new int[]{ 2, 4, 2, 5, 1}, 
                7
            )
        );
    }
}
