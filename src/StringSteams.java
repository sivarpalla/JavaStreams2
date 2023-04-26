import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringSteams {
    public static void main(String[] args) {
        "stress".chars()
                .mapToObj(c -> Character.valueOf((char)c))
                .collect(Collectors.toSet()) //remove duplicates
                .stream().sorted((s1,s2) ->s1.compareTo(s2))//increasing order
                .forEach(s -> System.out.println(s));

        String s="helloh";
        Arrays.asList(s.split("")).stream()//we can also use like this for bonding:  s.chars().mapToObj(i->(char)i)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new ,Collectors.counting()))
                .entrySet().stream().filter(e->e.getValue()==1).findFirst().ifPresent(c->System.out.println("1st non repeated character:"+c.getKey()));

        String[] s1={"Bill", "Bill", "Bill", "Sue", "Henry", "Henry"};
        String[] s2={"Bill", "Gene", "Sue"};

        List<String> flat =  Stream.concat(Arrays.stream(s1),Arrays.stream(s2)).collect(Collectors.toList());

        String[] result = flat.stream()
                .sorted(Comparator.comparing(x -> Collections.frequency(flat, x)).reversed())
                .toArray(String[]::new);

            
        System.out.println("result"); Arrays.stream(result).forEach(System.out::println);

        List<String> names = Arrays.asList(
                "Bond",
                "Einstein",
                "Alice",
                "Whitman",
                "Bob",
                "Spider"
        );
        int lengthOfLongestStr = names
                .stream()
                .peek(System.out::print)    //this will print the words
                .mapToInt(String::length)
                .peek(length -> System.out.println(":" + length))   // this will print the sizes
                .summaryStatistics()
                .getMax();
        System.out.println("\nLength of Longest String is = " + lengthOfLongestStr);
        List<Integer> numbers = Arrays.asList(
                2, 3, 5, 7, 11, 13, 17
        );


    }
}
