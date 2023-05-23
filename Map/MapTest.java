package Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class MapTest {
    public static void main(String[] args){
        Map<Integer, String> map = new TreeMap<>();
        map.put(1, "String1");
        map.put(2, "String2");
        map.put(-2, "");
        Iterator<Map<Integer, String>> iterator = map.iterator();
        System.out.println(map.entrySet());

    }
}
