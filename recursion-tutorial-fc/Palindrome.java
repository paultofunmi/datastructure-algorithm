public class Palindrome {

    public static boolean isPalindrome(String str) {

        if(str.length() == 1 || str.length() == 0) return true;

        if(str.charAt(0) == str.charAt(str.length() - 1)) {

            return isPalindrome(str.substring(1, str.length() - 1));
        }

        return false;

    }

    public static boolean isPalindrome2(String str) {

        int i = 0;
        int j = str.length() - 1;

        while(i < j) {

            if(str.charAt(i) == str.charAt(j)) {

                i++;
                j--;
            }else {

                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println(Palindrome.isPalindrome("kajak"));
        System.out.println(Palindrome.isPalindrome2("kajak"));
    }
}