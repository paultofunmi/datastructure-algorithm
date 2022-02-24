package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionTest {

    public static void binarySearch(List<Integer> list, int key) {

        Collections.sort(list);
        System.out.println(Collections.binarySearch(list, key));
    }

    public static void reverse(List<Integer> list) {

        Collections.sort(list);
        Collections.reverse(list);
        System.out.println(list);
    }

    public static void addAll(List<Integer> list, Set<Integer> set) {

        // list.addAll(set);
        set.addAll(list);
        System.out.println(set);        
    }

    public static void fillCollection(List<Integer> list, Set<Integer> set) {

        // list.addAll(set);
        set.addAll(list);
        System.out.println(set);        
    }

    public static void main(String[] args) {
        
        List<Integer> inputList = new ArrayList<Integer>(List.of(2,3,4,1));
        CollectionTest.binarySearch(inputList, 3);
        CollectionTest.reverse(inputList);
        CollectionTest.addAll(inputList, new HashSet<Integer>(List.of(2, 7 ,3)));
        System.out.println(Collections.emptyMap());
        System.out.println(Collections.emptySet());
        System.out.println(Collections.emptyList());

        List<Integer> inputList2 = new ArrayList<Integer>(List.of(2,3,4,1, 5, 7, 5));
        System.out.println(Collections.frequency(inputList2, 5));
        Collections.fill(inputList2, -1);
        System.out.println(inputList2);

        int intArray[] = new int[]{2,3,4,1, 5};
        Arrays.fill(intArray, -1);
        System.out.println(Arrays.toString(intArray));
    }
}
