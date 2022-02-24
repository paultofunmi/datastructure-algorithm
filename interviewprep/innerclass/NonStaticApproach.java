package interviewprep.innerclass;

public class NonStaticApproach {

    public void heyThere() {
        System.out.println("hey there");

        class LocalInnerClass {

            String localInnerVariable = "Hello Paul from class method";

            public void printVar() {

                System.out.println(localInnerVariable);
            }
        }

        LocalInnerClass localInnerClass = new LocalInnerClass();
        localInnerClass.printVar();
    }

    public class InnerClass {

        public void helloInner() {

            System.out.println("Hello Inner");
        }
    }
}
