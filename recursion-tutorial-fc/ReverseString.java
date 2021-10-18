public class ReverseString {

    public static String reverse(String in) {
        
        if(in.equals("")) return "";

        return reverse(in.substring(1)) + in.charAt(0);
    }


    public static void main(String[] args){

        System.out.println(ReverseString.reverse("Hello"));
        
        //""
        //o + l
        //lo + l
        //llo + e
        //ello + H
        //Hello
    }
}