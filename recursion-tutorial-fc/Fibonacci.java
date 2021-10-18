import java.util.Map;
import java.util.HashMap;

public class Fibonacci {
    
    public static Integer fib(int n, Map<Integer, Integer> cache)  {

        if(cache.containsKey(n)) return cache.get(n);
        
        int result = fib(n-2, cache) + fib(n-1, cache);
        cache.put(n, result);

        return result;
    }
    public static void main(String[] args) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);

        System.out.println(Fibonacci.fib(6, map));
        
    }
}
