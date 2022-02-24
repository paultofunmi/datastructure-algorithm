package collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {

    public static void main(String[] args) {
    
        Integer i = 10;
        System.out.println(i.hashCode());

        Integer i1 = 1000000000;
        System.out.println(i1.hashCode());


        Double d1 = 42.5;
        System.out.println(d1.hashCode());

        Double d2 = 42.5;
        System.out.println(d2.hashCode());
        
    
        Set<Integer> set1 = new HashSet<>();
        set1.add(8);
        set1.add(-2);
        set1.add(10);
        set1.add(null);
        set1.add(0);
        set1.add(null);

        System.out.println(set1);

        Set<String> set2 = new HashSet<>();
        set2.add("John");
        set2.add("Phil");
        set2.add("Mark");
        set2.add("Marki");
        set2.add("Alpha");
        set2.add(null);
        System.out.println(set2);


        Set<String> set3 = new LinkedHashSet<>();
        set3.add("John");
        set3.add("Phil");
        set3.add("Mark");
        set3.add("Marki");
        set3.add("Alpha");
        System.out.println(set3);

        Set<String> set4 = new TreeSet<>();
        set4.add("John");
        set4.add("Phil");
        set4.add("Mark");
        set4.add("Marki");
        set4.add("Alpha");
        System.out.println(set4);        
    }
}
