package Collection;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CollectionTest {
    public static void main(String[] args){
        List<String> c = new LinkedList<>();
        List<String> l = new LinkedList<>();
        l.add("aaa");
        l.add("baba");
        String[] tab = new String[2];
        l.toArray(tab);
        System.out.println("tab :  " + Arrays.toString(tab));
        c.add("babaaa");
        c.add("aaa");
        c.add("baba");
        System.out.println("c : " +c);
        System.out.println("d : " + l);

        System.out.println(c.containsAll(l));
        System.out.println("c : " +c);
        System.out.println("d : " + l);

    }
}
