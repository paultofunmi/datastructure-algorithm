package collections;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

//Java TreeMap is a Red-Black tree based implementation of Java’s Map interface.
/**
 * The entries in a TreeMap are always sorted based on the natural ordering of the keys, or based on a custom Comparator 
 * that you can provide at the time of creation of the TreeMap.
 * 
 * TreeMap implements NavigableMap (properties for navigating the map) implments SortedMap (provides interviewprep.sorting of keys) implements Map
 */
public class TreeMapTutorial {

    public static void printTreeMap() {

        SortedMap<String, String> fileExtensions  = new TreeMap<>();

        // Adding new key-value pairs to a TreeMap
        fileExtensions.put("python", ".py");
        fileExtensions.put("c++", ".cpp");
        fileExtensions.put("kotlin", ".kt");
        fileExtensions.put("golang", ".go");
        fileExtensions.put("java", ".java");

        // Printing the TreeMap (Output will be sorted based on keys)
        System.out.println(fileExtensions);
    }

    public static void navigateTreeMap() {

        TreeMap<Integer, String> employees = new TreeMap<>();

        employees.put(1003, "Rajeev");
        employees.put(1001, "James");
        employees.put(1002, "Sachin");
        employees.put(1004, "Chris");

        System.out.println("Employees map : " + employees);

        // Finding the size of a TreeMap
        System.out.println("Total number of employees : " + employees.size());

        // Check if a given key exists in a TreeMap
        Integer id = 1004;

        if(employees.containsKey(id)) {
            // Get the value associated with a given key in a TreeMap
            String name = employees.get(id);
            System.out.println("Employee with id " + id + " : " + name);
        } else {
            System.out.println("Employee does not exist with id : " + id);
        }

        // Find the first and last entry
        System.out.println("First entry in employees map : " + employees.firstEntry());
        System.out.println("Last entry in employees map : " + employees.lastEntry());

        // Find the entry whose key is just less than the given key
        Map.Entry<Integer, String> employeeJustBelow = employees.lowerEntry(1002);
        System.out.println("Employee just below id 1002 : " + employeeJustBelow);

        // Find the entry whose key is just higher than the given key
        Map.Entry<Integer, String> employeeJustAbove = employees.higherEntry(1002);
        System.out.println("Employee just above id 1002 : " + employeeJustAbove);
    }

    public static void removeEntryFromTreeMap() {

        TreeMap<String, String> countryISOCodeMapping = new TreeMap<>();

        countryISOCodeMapping.put("India", "IN");
        countryISOCodeMapping.put("United States of America", "US");
        countryISOCodeMapping.put("China", "CN");
        countryISOCodeMapping.put("United Kingdom", "UK");
        countryISOCodeMapping.put("Russia", "RU");
        countryISOCodeMapping.put("Japan", "JP");

        System.out.println("CountryISOCodeMapping : " + countryISOCodeMapping);

        // Remove the mapping for a given key
        String countryName = "Japan";
        String isoCode = countryISOCodeMapping.remove(countryName);
        if(isoCode != null) {
            System.out.println("Removed (" + countryName + " => " + isoCode + ") from the TreeMap. New TreeMap " + countryISOCodeMapping);
        } else {
            System.out.println(countryName + " does not exist, or it is mapped to a null value");
        }

        // Remove the mapping for the given key only if it is mapped to the given value
        countryName = "India";
        boolean isRemoved = countryISOCodeMapping.remove(countryName, "IA");
        System.out.println("Was the mapping removed for " + countryName + "? : " + isRemoved);

        // Remove the first entry from the TreeMap
        Map.Entry<String, String> firstEntry = countryISOCodeMapping.pollFirstEntry();
        System.out.println("Removed firstEntry : " + firstEntry + ", New TreeMap : " + countryISOCodeMapping);

        // Remove the last entry from the TreeMap
        Map.Entry<String, String> lastEntry = countryISOCodeMapping.pollLastEntry();
        System.out.println("Removed lastEntry : " + lastEntry + ", New TreeMap : " + countryISOCodeMapping);
    }

    public static void main(String[] args) {
        
        // TreeMapTutorial.printTreeMap();
        // TreeMapTutorial.navigateTreeMap();
        TreeMapTutorial.removeEntryFromTreeMap();   
    }
    
}
