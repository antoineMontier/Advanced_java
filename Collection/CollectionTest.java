package Collection;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Iterator;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class CollectionTest {
    public static void main(String[] args){
        List<Integer> l = new LinkedList<>();
        l.add(16); l.add(3); l.add(11); l.add(8); l.add(5); l.add(1);
        System.out.println("list after construction : " + l);


        /*System.out.println(l.stream()
                            .takeWhile(k -> k.length() > 4)
                            .sorted((a, b) -> (a.length() - b.length()))
                            .map(a -> a + ":" + a.length())
                            .limit(10)
                            .map(
                                s -> s + l  .stream()
                                            .map(a -> a.toString() + " # " + s.toString())
                                            .map(k -> k.toString() +   s.toUpperCase()
                                                                        .toString())
                                            .limit(2*l  .stream()
                                                        .max((a, b) -> (a.length() - b.length()))
                                                        .get()
                                                        .length() - s.length())
                                            .max((a, b) -> (a.length() - b.length()))
                                            .get()
                                )
                            .map(s -> s.split(" # ")[1])
                            .map(s -> s + "\t\t" + s.length())
                            .reduce("", (a, b) -> a + " || " + b)
        );*/
        // sort method with a comparator
        l.sort((a, b) -> a - b);
        
        // prebuilt comparators
        l.sort(Comparator.naturalOrder());
        l.sort(Comparator.reverseOrder());

        // Collections sorting
        Collections.sort(l);


        // streams sorting
        l = l.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        l.forEach(System.out::println);
    }

}
