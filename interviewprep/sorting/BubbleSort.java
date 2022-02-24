package interviewprep.sorting;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {

    private static void bubble() {

        Random rand = new Random();
        int[] numbers = new int[50000];

        for(int i = 0; i < numbers.length; i++) {

            numbers[i] = rand.nextInt(1000000);
        }

//        System.out.println("array before interviewprep.sorting: " + Arrays.toString(numbers));

        boolean swapped = true;

        Long startTime = System.currentTimeMillis();
        while(swapped) {

            swapped = false;
            for(int i = 0; i< numbers.length - 1; i++) {
                if(numbers[i] > numbers[i + 1]) {
                    swapped = true;
                    int temp = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i+1] = temp;
                }
            }
        }

        Long stopTime = System.currentTimeMillis();
        System.out.println("array after interviewprep.sorting: " + Arrays.toString(numbers));

        System.out.println("It took " + (stopTime - startTime)  + " milliseconds");
    }

    public static void main(String[] args) {

        BubbleSort.bubble();
    }
}
