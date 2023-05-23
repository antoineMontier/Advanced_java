package Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class MapTest {
    public static void main(String[] args){
        Map<Integer, String> map = new TreeMap<>();
        map.put(1, "String1");
        map.put(2, "String2");
        map.put(-2, "");
        System.out.println(map.size());
        // ==============================================
        // Set<Entry<Integer, String>> s = map.entrySet();
        // Iterator<Entry<Integer, String>> it = s.iterator();
        // while (it.hasNext()) 
        //     System.out.println(it.next());
        // System.out.println(s);

    }

}
