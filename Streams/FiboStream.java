import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FiboStream{
    public static void main(String[] args){
        System.out.println(fibo(10));
    }

    public static String fibo(int n){
        return  Stream
                .iterate(new long[]{0, 1}, fib -> new long[]{fib[1], fib[0] + fib[1]})
                .map(fib -> fib[0])
                .limit(n+1)
                .skip(n)
                .collect(Collectors.toList())
                .get(0)
                .toString();
    }
}