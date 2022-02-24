package com.solutions;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeating {
    
    public static int lengthOfLongestSubstring(String s) {
        
        Map<Character, Integer> map = new HashMap<>();
        
        int start = 0;
        int end = 0;
        int maxLength = 0;
        
        while(end < s.length()) {
            
            Character cChar = s.charAt(end);
            
            if(map.containsKey(cChar) && map.get(cChar) >= start) {
                
                start = map.get(cChar) + 1;
            }

            map.put(cChar, end);    
            
            maxLength = Math.max(maxLength, end - start + 1);    
            end++;
        }
        
        return maxLength;
    }

    public static void main(String[] args) {

        System.out.println(LongestSubStringWithoutRepeating.lengthOfLongestSubstring("abcabcbb"));
        // System.out.println(com.solutions.LongestSubStringWithoutRepeating.lengthOfLongestSubstring("bbbbb"));
        // System.out.println(com.solutions.LongestSubStringWithoutRepeating.lengthOfLongestSubstring("pwwkew"));
    }
}
