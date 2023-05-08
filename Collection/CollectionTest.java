package Collection;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class CollectionTest {
    public static void main(String[] args){
        List<String> l = new LinkedList<>();
        l.add("a"); l.add("b"); l.add("c"); l.add("d"); l.add("a");
        Iterator<String> it = l.iterator();
        while(it.hasNext())
            System.out.printf("it : %s\t", it.next());
            System.out.println("");
    }
}
