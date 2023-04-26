import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;

//Requirements of a TreeMap
//Each node is either red or black
//all leaves are black. Root node is mostly black.
//if node is red then all the children are black
//Important: Every path from a given node to any of its descendant NIL nodes contains the same number of black nodes
public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<Integer,String> map = new TreeMap();
        //TreeMap<Integer,String> map1 = new TreeMap(Comparator.reverseOrder());
        map.put(100,"Tom");
        map.put(200,"Peter");
        map.put(300,"Goan");
        map.put(500,"Amar");
        map.put(900,"Bob");
        System.out.println(map);
        System.out.println(map.lastKey()+" is last and first is:"+map.firstKey());
        Set<Integer> keyLessThan300 = map.headMap(300).keySet();
        System.out.println(keyLessThan300);
        Set<Integer> keyGreaterThan300 = map.tailMap(300).keySet();
        System.out.println(keyGreaterThan300);
    }
}
