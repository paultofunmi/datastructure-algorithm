package collections;


import java.util.PriorityQueue;

//A priority queue in Java is a special type of queue wherein all the elements are ordered as per their natural ordering or 
// based on a custom Comparator supplied at the time of creation
// Extends AbstractQueue implements Queue -> Collection -> Iterable
public class PriorityQueueTest {
   
    
    public static void printElement() {

        PriorityQueue<Integer> numbers = new PriorityQueue<>();

        // Add items to a Priority Queue (ENQUEUE)
        numbers.add(750);
        numbers.add(500);
        numbers.add(900);
        numbers.add(100);

        // Remove items from the Priority Queue (DEQUEUE)
        while (!numbers.isEmpty()) {
            System.out.println(numbers.poll());
        }

        System.out.println(numbers);
    }

    public static void main(String[] args) {
        
        PriorityQueueTest.printElement();

    }
}
