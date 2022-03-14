package interviewprep.patternmatching;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberMatcher {

    private static boolean check(String number) {

        //+2348115225101 || +23408115225101
        //08115225101 || 8115225101
        Pattern pattern1 = Pattern.compile("^(\\+)?(234)?(0)?\\d{10}$");
        Matcher matcher = pattern1.matcher(number);

        return matcher.matches();
    }

    public static void main(String[] args) {

        System.out.println(PhoneNumberMatcher.check("234"));
        System.out.println(PhoneNumberMatcher.check("+234"));
        System.out.println(PhoneNumberMatcher.check("+234008115225101"));
        System.out.println(PhoneNumberMatcher.check("234008115225101"));

        System.out.println(PhoneNumberMatcher.check("+23408115225101"));
        System.out.println(PhoneNumberMatcher.check("+2348115225101"));
        System.out.println(PhoneNumberMatcher.check("2348115225101"));
        System.out.println(PhoneNumberMatcher.check("23408115225101"));
        System.out.println(PhoneNumberMatcher.check("08115225101"));
        System.out.println(PhoneNumberMatcher.check("8115225101"));
    }
}
