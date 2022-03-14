package com.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Different ways to solve this: DP, Backtracking, Stacks, Pointers
 *
 *
 */
public class GenerateParentheses {

    public static void main(String[] args) {

        System.out.println(GenerateParentheses.generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        process("", n, n, result);
//        process("", 0, 0, result, 2);
        return result;
    }
    private static void process(String prefix, int left, int right, List<String> result) {
//    private static void process(String prefix, int left, int right, List<String> result, int max) {
//          if(prefix.length() == max * 2) {
//              result.add(prefix);
//              return;
//          }
//
//          if(left < max) {
//              process(prefix + '(', left + 1, right, result, max);
//          }
//
//          if(right < left) {
//              process(prefix + ')', left, right + 1, result, max);
//          }
        if (left == 0 && right == 0) {
            result.add(prefix);
            return;
        }

        if (left > 0) {
            process(prefix + '(', left - 1, right, result);
        }

        if (left < right) {
            process(prefix + ')', left, right - 1, result);
        }
    }
}


