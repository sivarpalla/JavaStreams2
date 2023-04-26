import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Frequency {
    public static void main(String[] args) {
        int [] arr = new int [] {1, 2, 8, 3, 2, 2, 2, 5, 1};
        int [] fr = new int [arr.length];//Array fr will store frequencies of element
        int visited = -1;
        for(int i = 0; i < arr.length; i++){
            int count = 1;
            for(int j = i+1; j < arr.length; j++){
                if(arr[i] == arr[j]){
                    count++;
                    //To avoid counting same element again
                    fr[j] = visited;
                }
            }
            if(fr[i] != visited)
                fr[i] = count;
        }

        System.out.println(" Element | Frequency Displays");
        for(int i = 0; i < fr.length; i++){
            if(fr[i] != visited)
                System.out.println("    " + arr[i] + "    |    " + fr[i]);
        }
        System.out.println(" Displays2");
         //Arrays.stream(arr).boxed().forEach(e-> System.out.println(e));
      Map<Integer,Long> map=  Arrays.stream(arr).mapToObj(i->Integer.valueOf(i)).collect(Collectors.groupingBy(i->i,Collectors.counting()));
               map .entrySet().forEach(e-> System.out.println(e.getKey()+"-"+e.getValue()));
    }
}
