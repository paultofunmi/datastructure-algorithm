package interviewprep.collection;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

// https://www.callicoder.com/java-hashmap/
// HashMap implements Map
public class HashMapTutorial {
    
    public static void testPutFunction() {

        Map<String, Integer> mapping = new HashMap<>();

        mapping.put("One", 1);
        mapping.put("Two", 2);
        mapping.put("Three", 3);
        Integer returnVal = mapping.put("Three", 33);

        //Return 3
        System.out.println(returnVal);

        System.out.println(mapping);
    }

    public static void accessKeysFromHashMap() {

        Map<String, String> userCityMapping = new HashMap<>();

        // Check if a HashMap is empty
        System.out.println("is userCityMapping empty? : " + userCityMapping.isEmpty());

        userCityMapping.put("John", "New York");
        userCityMapping.put("Rajeev", "Bengaluru");
        userCityMapping.put("Steve", "London");

        System.out.println("userCityMapping HashMap : " + userCityMapping);

        // Find the size of a HashMap
        System.out.println("We have the city information of " + userCityMapping.size() + " users");

        String userName = "Steve";

        // Check if a key exists in the HashMap
        if(userCityMapping.containsKey(userName)) {
            // Get the value assigned to a given key in the HashMap
            String city = userCityMapping.get(userName);
            System.out.println(userName + " lives in " + city);
        } else {
            System.out.println("City details not found for user " + userName);
        }

        // Check if a value exists in a HashMap
        if(userCityMapping.containsValue("New York")) {
            System.out.println("There is a user in the userCityMapping who lives in New York");
        } else {
            System.out.println("There is no user in the userCityMapping who lives in New York");
        }

        // Modify the value assigned to an existing key
        userCityMapping.put(userName, "California");
        System.out.println(userName + " moved to a new city " + userCityMapping.get(userName) + ", New userCityMapping : " + userCityMapping);

        // The get() method returns `null` if the specified key was not found in the HashMap
        System.out.println("Lisa's city : " + userCityMapping.get("Lisa"));
    }

    public static void removeKeysFromHashMap() {

        Map<String, String> husbandWifeMapping = new HashMap<>();
        husbandWifeMapping.put("Jack", "Marie");
        husbandWifeMapping.put("Chris", "Lisa");
        husbandWifeMapping.put("Steve", "Jennifer");

        System.out.println("Husband-Wife Mapping : " + husbandWifeMapping);

        // Remove a key from the HashMap
        // Ex - Unfortunately, Chris got divorced. Let's remove him from the mapping
        String husband = "Chris";
        String wife = husbandWifeMapping.remove(husband);
        
        System.out.println("Couple (" + husband + " => " + wife + ") got divorced");
        System.out.println("New Mapping : " + husbandWifeMapping);

        // Remove a key from the HashMap only if it is mapped to the given value
        // Ex - Divorce "Jack" only if He is married to "Linda"
        boolean isRemoved = husbandWifeMapping.remove("Jack", "Linda");
        System.out.println("Did Jack get removed from the mapping? : " + isRemoved);

        // remove() returns null if the mapping was not found for the supplied key
        wife = husbandWifeMapping.remove("David");
        if(wife == null) {
            System.out.println("Looks like David is not married to anyone");
        } else {
            System.out.println("Removed David and his wife from the mapping");
        }
    }

    /**
     *  Map Interface provides methods to retrieve the set of entries (key-value pairs), the set of keys, and the collection of values
     */
    public static void loopingThroughHashMap() {
        
        Map<String, String> countryISOCodeMapping = new HashMap<>();

        countryISOCodeMapping.put("India", "IN");
        countryISOCodeMapping.put("United States of America", "US");
        countryISOCodeMapping.put("Russia", "RU");
        countryISOCodeMapping.put("Japan", "JP");
        countryISOCodeMapping.put("China", "CN");


        // HashMap's entry set
        Set<Map.Entry<String, String>> entrySet = countryISOCodeMapping.entrySet();
        // System.out.println(entrySet);

        //Using entries in entrySet to loop
        // System.out.println("-----Using EntrySet----");
        for(Map.Entry<String, String> entry: countryISOCodeMapping.entrySet()) {

            // System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        //Using Iterator
        // System.out.println("-----Using Iterator----");
        Iterator<Map.Entry<String, String>> iterator = countryISOCodeMapping.entrySet().iterator();

        while(iterator.hasNext()) {

            Map.Entry<String, String> entry = iterator.next();
            // System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        //Using Lambda
        // System.out.println("-----Using Lambda-----");
        // countryISOCodeMapping.forEach((k, v) -> System.out.println(k + " : " + v));

        //Using Streams
        // System.out.println("-----Using Streams-----");
        // countryISOCodeMapping.entrySet().stream().forEach( e -> System.out.println(e.getKey() + " : " + e.getValue()));

        // List<String> str = Arrays.asList("a", "b", "c", "d");
        List<String> list = Arrays.asList("A", "B", "C", "D");

        // list.forEach(System.out::println); //uses collection iterator(if one is specified)s
        // list.stream().forEach(System.out::println); //takes element one by one from list ignoring the iterator
    }

    public static void main(String[] args) {
        

        // HashMapTutorial.testPutFunction();
        // HashMapTutorial.accessKeysFromHashMap();
        // HashMapTutorial.removeKeysFromHashMap();
        // HashMapTutorial.loopingThroughHashMap();

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Set<Node> hashSet = new HashSet<>();

        hashSet.add(n1);
        hashSet.add(n2);
        hashSet.add(n3);
//        System.out.println(hashSet);

        Set<String> linkedSet = new LinkedHashSet<>();
        linkedSet.add(null);
        linkedSet.add("1");
        linkedSet.add(null);
        System.out.println("linkedSet: " + linkedSet);

        Map<String, String> linkedMap = new LinkedHashMap<>();
        linkedMap.put(null, "1");
        linkedMap.put(null, "2");
        linkedMap.put(null, "3");
        System.out.println("linkedMap: " + linkedMap);
    }

    static class Node {

        int val;

        Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }
}
