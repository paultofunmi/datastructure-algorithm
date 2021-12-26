package generic;

public class SumOfNumersThatAddUp {
    
    public static int run(int[] arr, int size, int target) {
        int count = 0;

        for(int i = 0; i < arr.length; i++) {

            count += findSum(arr, i, size, target);
        }

        return count;
    }

    private static int findSum(int[] arr, int pos, int size, int target) {

        int count = 0;
        if(pos + size  - 1 > arr.length - 1) return count;
        int start = pos; 
        int end = pos  + size - 1;
        
        while(start < end) {

            if(arr[start] + arr[end] >= target) {

                System.out.println("start: " + start + " end: " +end);
                ++count;
            } 

            ++start;
            if(count > 0) break;
        }

        return count;
    }
    
    public static void main(String[] args) {
        
        int[] arr1 = {2, 4, 2, 7};

        int[] arr2 = {2, 4, 2, 7, 1, 6, 1, 1, 1};

        int[] arr3 = {2, 3, 3, 3, 4, 3, 2, 1, 2, 4};
        System.out.println(SumOfNumersThatAddUp.run(arr2, 4, 8));
    }
}
