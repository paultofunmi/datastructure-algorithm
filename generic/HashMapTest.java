package generic;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HashMapTest {
    
    public static void fillHashMap(int[] arr) {

        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        
        for(int a : arr) {

            for(int i = 0; i < 3; i++){

                int rand = Math.round((float)Math.random() * 10);
            
                map.computeIfAbsent(a, k -> new PriorityQueue<Integer>()).add(rand);
            }            
        }

        System.out.println(map);

        for(int a: arr) {

            while(map.get(a).size() > 0) {

                System.out.print(map.get(a).poll() + " ");;
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        
        HashMapTest.fillHashMap(new int[]{0,1,2,3});

    }
}
