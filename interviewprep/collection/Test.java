package interviewprep.collection;

import java.util.Arrays;

public class Test {
    
  int i[] = {0};
   
   public static void main(String args[]) {
            
        int[] a = {0, 2, 4};
        int[] b = new int[]{2, 4, 6};
        int[] c[] = {{2, 3}, {1, 5}};
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));
        int i[] = {1};
        change_i(i);
        System.out.println(i[0]);
   }

   public static void change_i(int i[]) {
      int j[] = {2};
      i = j;
   }
}
