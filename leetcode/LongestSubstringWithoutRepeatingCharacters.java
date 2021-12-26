package leetcode;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    
    public static int count(String str) {

        int result = 0;
        Set<Character> seen1 = new HashSet<>();
        int start = 0; 
        int end = 0;
        
        while(end < str.length()) {
            
            char cChar = str.charAt(end);

            if(!seen1.contains(cChar)) {

                seen1.add(cChar);
            }else {

                seen1.clear();
                seen1.add(cChar);

                start = end;
            }

            int tempLength = end - start + 1;
            result = Math.max(result, tempLength);
            end++;
        }

        return result;
    }

    public static void main(String[] args) {
        
        //3
        System.out.println(
            LongestSubstringWithoutRepeatingCharacters.count("PWWKEW")
        );

        //2
        System.out.println(
            LongestSubstringWithoutRepeatingCharacters.count("abba")
        );

        //2
        System.out.println(
            LongestSubstringWithoutRepeatingCharacters.count("dvdf")
        );


        //3
        System.out.println(
            LongestSubstringWithoutRepeatingCharacters.count("abcabcbb")
        );

        //1
        System.out.println(
            LongestSubstringWithoutRepeatingCharacters.count("bbbb")
        );

        //0
        System.out.println(
            LongestSubstringWithoutRepeatingCharacters.count("")
        );


    }
}
