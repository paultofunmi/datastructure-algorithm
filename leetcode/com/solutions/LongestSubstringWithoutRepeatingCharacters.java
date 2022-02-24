package com.solutions;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<>();
        int low = 0;
        int result = 0;

        for(int i = 0; i< s.length(); i++) {

            Character cChar = s.charAt(i);

            if(map.get(cChar) != null && low <= map.get(cChar)) {

                low = map.get(cChar) + 1;
            }

            map.put(cChar, i);
            result = Math.max(result, i - low + 1);
        }


        return result;
    }

    public static void main(String[] args) {

//        System.out.println(LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abba"));
    }
}
