package com.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Count the first non-repeating character in a string
 */
public class GSII {

    public static char countFirst(String input)
    {

        if(input == null) return 0;
        Map<Character, Integer> map = new HashMap<>();

        for(char currentChar: input.toCharArray()) {

            if(map.containsKey(currentChar)) {
                map.put(currentChar, map.get(currentChar) + 1);
            }else {
                map.put(currentChar, 1);
            }
        }

        for(char currentChar: input.toCharArray()) {
            if(map.get(currentChar) == 1) return currentChar;
        }

        return 0;
    }

    /*
     **  Returns true if the tests pass. Otherwise, returns false;
     */
    public static void doTestsPass()
    {
        // Base test case
        String[] input = { "apple", "abbcc", null, "aabbc", ""};
        char[] output = { 'a', 'a', 0, 'c', 0};

        for(int i = 0; i < input.length; i++) {
            if(countFirst(input[i]) == output[i]) {
                System.out.println("Test passed for " + input[i]);
            }else {
                System.out.println("Test failed for " + input[i]);
            }
        }
    }

    /*
     **  Execution entry point.
     */
    public static void main(String[] args)
    {
        doTestsPass();
    }
}

