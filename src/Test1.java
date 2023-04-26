import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test1 {

    public static void main(String[] args) {
        //month with 31days
        //1st date is monday
        //o/p: print mond, wed, fri dates

        IntStream.range(1,31).forEach(d->{
            if(d%7==1)
                System.out.println("Monday:"+d);
            if(d%7==3)
                System.out.println("Wed:"+d);
            if(d%7==5)
                System.out.println("Fri:"+d);
        });
//utility


        List<Integer> list= Arrays.asList(2,3,4,156,1,2,4);
        Collections.sort(list);
        Integer secondLargest = list.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        Integer avg = list.stream().collect(Collectors.averagingInt(i->i)).intValue();
        System.out.println("avg:"+avg);

        list.stream().distinct().forEach(x->System.out.println(x));

        int[][] array = {{1,2,3},{4,5},{6}};
        int sum = Arrays.stream(array).flatMapToInt(x -> Arrays.stream(x)).sum();
        System.out.println("sum:"+sum);

        //any 2 numbers
        //any 3 nuumbers sum ==20
//        list.
    }
}
