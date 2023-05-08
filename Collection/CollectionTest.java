package Collection;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;
import java.util.Collection;

public class CollectionTest {
    public static void main(String[] args){
        List<String> l = new LinkedList<>();
        l.add("antoine"); l.add("boubouee"); l.add("cassis"); l.add("denrée"); l.add("album"); l.add("azertyuiop");
        System.out.println("list after construction : " + l);


        System.out.println(l.stream()
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
        );
    }

}
