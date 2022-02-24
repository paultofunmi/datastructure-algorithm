package interviewprep.stringprep;

public class StringTest {

    /**
     * Java String objects are immutable (in memory)
     * - it enables java save memory space
     * - for security (imagine String account = 123933; if the value stored account can be changed after validation, security risk arises.
     * - threadsafe (since String is immutable, all threads can use it without worrying about it being changed)
     */
    public static void testStringImmutable() {

        /**
         * Creating String object from a literal puts that String object in a String Pool
         * Everytime another String literal is created, Java checks if that object already exists in Pool
         */
        String name = "John";
        String anotherName = "John";

        //Using this, does not use shared pool but creates a brand new object outside of the String pool
        String thirdName = new String("John");
        System.out.println(name == anotherName); //true
        System.out.println(name == thirdName); //false
    }

    public static void main(String[] args) {

        StringTest.testStringImmutable();
    }
}
