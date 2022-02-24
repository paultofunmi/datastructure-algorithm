package com.solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DigitTreeSum {
    
    static long ssolution(Tree t) {

        if(t == null) return 0L;
        
        List<String> result = new ArrayList<>();
        
        doRecursion(t, result, "");
        System.out.println(result);
        return result.stream().filter(n -> n.length()> 0).mapToLong(n -> Long.parseLong(n)).reduce(0, Long::sum);
    }
    
    
    private static void doRecursion(Tree t, List<String> result, String parent) {
        
        if(t.left == null && t.right == null) {         
            result.add(parent.concat(String.valueOf(t.value))); 
            return;   
        }
        
        if(t != null) {
            doRecursion(t.left, result, parent.concat(String.valueOf(t.value)));
            doRecursion(t.right, result, parent.concat(String.valueOf(t.value)));    
        }
    }

    public static void main(String[] args) {
        
        Tree source = new Tree(1);
        source.left = new Tree(0);
        source.right = new Tree(4);

        source.left.left = new Tree(3);
        source.left.right = new Tree(1);

        System.out.println(DigitTreeSum.ssolution(source));;
        
    }
}


