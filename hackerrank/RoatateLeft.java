import java.util.ArrayList;
import java.util.List;

public class RoatateLeft {

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        
        List<Integer> result = new ArrayList<>();

        for(int i = d; i < a.size(); i++) {

            result.add(a.get(i));
        }

        for(int i = 0; i < d; i++) {
            result.add(a.get(i));
        }

        return result;
    }

    public static void main(String[] args) {
        
        System.out.println(RoatateLeft.rotLeft(List.of(1,2,3,4,5), 4));
        System.out.println(RoatateLeft.rotLeft(List.of(1,2,3,4,5), 2));
    }
}
