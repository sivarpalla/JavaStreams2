import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Any3numbers {

    //greatest sum of any 2 numbers
    public static void main2(String[] args) {
        int[] arr={2,4,6,8,9,11,22,12,13,5};
        int sum=0,a=0,b=0;
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(sum<arr[j]+arr[i]){
                    sum=arr[j]+arr[i];
                    a=arr[i];
                    b=arr[j];
                }
            }
        }
        System.out.println(a+" "+b+" "+sum);
    }

    //find all combinations of any 3 numbers to a perticular sum
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 9, 11, 2, 8, 21, 1);

        // find sum of largest 2 numbers using Stream.skip(); method
        int sum = numbers
                .stream().mapToInt(i->Integer.valueOf(i))
                .sorted()
//                .filter((a,b)->a%10==b%10)
                .skip(numbers.size() - 2)
                .reduce(0,  Integer::sum);
        System.out.println("x:"+sum);

    }
}
