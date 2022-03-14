package com.solutions;

public class LongestPalindromicSubstring {

    int startIdx = 0;
    int maxLength = 1;

    public String longestPalindrome(String s) {

        for(int i = 0; i < s.length(); i++){

            expandAroundMiddle(i, i, s);
            expandAroundMiddle(i, i + 1, s);
        }

        return s.substring(startIdx, startIdx + maxLength);

    }

    private void expandAroundMiddle(int left, int right, String inputString){

        while(left >=0 && right < inputString.length() &&
                inputString.charAt(left) == inputString.charAt(right)){
            final int currentPalLength = right - left + 1;

            if(currentPalLength > maxLength){
                maxLength = currentPalLength;
                startIdx = left;
            }

            left--;
            right++;
        }
    }

    public static void main(String[] args) {

        LongestPalindromicSubstring ins1 = new LongestPalindromicSubstring();
        System.out.println(ins1.longestPalindrome("babad"));
        LongestPalindromicSubstring ins2 = new LongestPalindromicSubstring();
        System.out.println(ins2.longestPalindrome("cbbd"));
        LongestPalindromicSubstring ins3 = new LongestPalindromicSubstring();
        System.out.println(ins3.longestPalindrome("abba"));
    }

}
