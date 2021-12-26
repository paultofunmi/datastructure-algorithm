package leetcode;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    
    public static void main(String[] args) {
        
        RansomNote.canConstruct("aa", "ab");
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        
        boolean result = true;
        
        Map<Character, Integer> dict = new HashMap<>();
        
        for(int i = 0; i < magazine.length(); i++) {
            
            Character currentChar = magazine.charAt(i);
            
            if(dict.get(currentChar) == null) {
                
                dict.put(currentChar, 1);
            }else {
                
                dict.put(currentChar, dict.get(currentChar) + 1);
            }
        }
        
        
        for(int j = 0; j < ransomNote.length(); j++) {
            
            Character currentChar = ransomNote.charAt(j);
            
            if(dict.containsKey(currentChar) && dict.get(currentChar) > 0) {
                
                dict.put(currentChar, dict.get(currentChar) - 1);
                
            }else {
                
                return false;
            }
        }
        
        
        
        return result;
    }
}
