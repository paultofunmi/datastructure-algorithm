package interviewprep.innerclass;

public class DriverInnerClass {

    public static void main(String[] args) {

        /**
         * Three ways for InnerClasses:
         * - static
         * - non-static
         * - local method
         */
        NonStaticApproach outer = new NonStaticApproach();
        outer.heyThere();

        NonStaticApproach.InnerClass inner = outer.new InnerClass();
        inner.helloInner();

        /**
         * Static Way
         */
        StaticApproach outer1 = new StaticApproach();
        outer1.heyThere();

        StaticApproach.InnerClass inner1 = new StaticApproach.InnerClass();
        inner1.helloInner();
    }
}
