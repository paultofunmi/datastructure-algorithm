public class DecimalToBinary {

    public static String convert(int number) {

        if(number == 0) return "";

        return convert(number / 2) + "" + number % 2;
    }

    public static void main(String[] args) {

        System.out.println(DecimalToBinary.convert(2));
    }
}