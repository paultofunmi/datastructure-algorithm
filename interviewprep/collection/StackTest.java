package interviewprep.collection;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * doc: https://docs.oracle.com/javase/8/docs/api/java/util/Stack.html
 * 
 */
public class StackTest {
    

    public static void main(String[] args) {
        
        
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        while(!stack.isEmpty()) {
            
            System.out.println(stack.pop());
        }
    }

}
