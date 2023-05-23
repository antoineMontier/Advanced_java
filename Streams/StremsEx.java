import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StremsEx {
    public static void main(String[] args){
        // List<Integer> l = new ArrayList<>();
        // Random r = new Random();
        // for(int i = 0 ; i < 10 ; ++i) l.add(r.nextInt(20));
        // System.out.println(sumOfSquaredEvenNumbers(l));

        // List <String> names = Arrays.asList("John", "Alice", "Charlie", "John", "Bob", "Alice");
        // System.out.println("Sorted Unique Names: " + getSortedUniqueNames(names));

        List<Integer> numbers = Arrays.asList(1, -2, 3, 4, -5, 6);
        System.out.println("Average of positive integers: " + calculateAverageOfPositiveIntegers(numbers));


    }

    public static int sumOfSquaredEvenNumbers(List<Integer> numbers){
        return numbers  .stream()
                        .filter(s -> (s % 2 == 0))
                        .map(s -> s*s)
                        .reduce(0, (a, b) -> a + b);
    }

    public static List<String> getSortedUniqueNames(List<String> names){
        return names    .stream()
                        .filter(n -> (names.stream().filter(p -> (p.equals(n))).count() <= 1))
                        .sorted((a, b) -> a.compareTo(b))
                        .collect(Collectors.toList());
    }


    public static double calculateAverageOfPositiveIntegers(List<Integer> numbers){
        return numbers  .stream()
                        .filter(a -> (a >= 0))
                        .collect(0, (p, q) -> p + q) / 
        (double)numbers .stream()
                        .filter(a -> (a >= 0))
                        .count();
    }


}
