package collections;

import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetTutorial {

    public static void printElements(){

        TreeSet<String> fruits = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        // Adding new elements to a TreeSet
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Pineapple");
        fruits.add("Orange");

        System.out.println("Fruits Set : " + fruits);

        // Duplicate elements are ignored
        fruits.add("Apple");
        System.out.println("After adding duplicate element \"Apple\" : " + fruits);

        // This will be allowed because it's in lowercase.
        fruits.add("banana");
        System.out.println("After adding \"banana\" : " + fruits);

        while(fruits.size() > 0 ) {

            System.out.println(fruits.pollFirst());
        }
    }
    public static void main(String[] args) {
    
        TreeSetTutorial.printElements();
    }
}
