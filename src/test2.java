import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class test2 {

    public static void main(String[] args) {
        int a[]={100,8,90,70,5,200};
        IntStream stream= Arrays.stream(a);
        stream
                //.boxed()
                .mapToObj(i->Integer.valueOf(i)).sorted(Comparator.reverseOrder())
                .limit(3).forEach(n->System.out.println(n));
        //int a[]={};
//        Arrays.asList(100,8,90,70,5,200).stream().sorted(Comparator.reverseOrder()).skip(a.length-3).forEach(n->System.out.println(n));
        List<Integer> l1=Arrays.asList(1,3,5,7,9,10,2);

        List<Integer> l2=Arrays.asList(1,2,3);
        //get hash set of common elements.
        Set<Integer> st= Stream.concat(l1.stream(), l2.stream()).collect(Collectors.groupingBy(i->i,Collectors.counting()))
                .entrySet().stream().filter(x->x.getValue()==1).map(x->x.getKey()).collect(Collectors.toSet());
        st.forEach(n->System.out.println(n));

        //another way of just printing
       Stream.concat(l1.stream(),l2.stream()).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
               .entrySet().stream().filter(x->x.getValue()>1).
               forEach(m->System.out.println(m.getKey()+" count"+m.getValue()));

        System.out.println("Another way");
        Stream.of(l1,l2).flatMap(list->list.stream()).collect(Collectors.groupingBy(i->i,Collectors.counting()))
                .entrySet().stream().filter(x->x.getValue()==1).map(x->x.getKey()).collect(Collectors.toSet()).forEach(n->System.out.println(n));

        String[] arrays = {null,"Australia","India", "Albania", "Malaysia", "Peru"};
        List<String> input = Arrays.asList(arrays);
// List<String> Output = {"AustraliaAA", "AlbaniaAA"}

        List<String> Output = input.stream()
                .filter(c-> c!=null && c.charAt(0)==c.toUpperCase().charAt(c.length()-1))
                //.filter( c-> c.charAt(0)==c.toUpperCase().charAt(c.length()-1))
                .map(c->c.concat(c.charAt(0)+""+c.charAt(0)))
                .collect(Collectors.toList());

        System.out.println("Output:"+Output);
    }
}
