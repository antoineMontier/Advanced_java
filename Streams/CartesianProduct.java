package Streams;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class CartesianProduct {
    /// goal is to compute a cartesian product between two lists
    public static void main(String[] args){

        List<Integer> list1 = Arrays.asList(2, 3, 4, 5);
        List<Character> list2 = Arrays.asList('a', 'b', 'c', 'd');

        List<String> res = cartesianProduct(list1, list2);
        
        res.stream().forEach(s -> System.out.println(s));

    }

    public static <T, U> List<String> cartesianProduct(List<T> l1, List<U> l2){
        return l1.stream()
                    .flatMap((T s1) -> l2.stream().map((U s2) -> s1.toString() + s2.toString()))
                    .collect(Collectors.toList());    
    }
}
