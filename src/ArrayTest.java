import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayTest {

    public static void main(String[] args) {
        long[] A= {1, 2, 5, 4, 0};
        long[] B= {2, 4, 5, 0, 1};
        int N=5;
        //System.out.println("check:"+check(A,B,N));

        //int[] arr={1, -1, 3, 2, -7, -5, 11, 6};
        int[] arr={-2, 10, -3, -4, 8};
        segregateElements(arr,5);
        Arrays.stream(arr).forEach(System.out::println);
       int[] a={2 ,1 ,3};
        System.out.println("missingNumber:"+missingNumber(a,a.length));
    }

    //Function to check if two arrays are equal or not.
    public static boolean check(long A[],long B[],int N)
    {
        // Arrays.sort(A);
        // Arrays.sort(B);
        // for(int i=0;i<N;i++){
        //     if(A[i]!=B[i])
        //         return false;
        // }
        // return true;

        Map<Integer, Integer> m1=new HashMap<>();
        Map<Integer, Integer> m2=new HashMap<>();
        for(int i=0;i<N;i++){
            m1.put((int)A[i],m1.getOrDefault((int)A[i],0)+1);
            m2.put((int)B[i],m2.getOrDefault((int)B[i],0)+1);
        }

        for(int key:m1.keySet()){
            if(!m2.containsKey(key) || m1.get(key)!=m2.get(key)){
                return false;
            }
        }
        return true;
    }

    public static void segregateElements(int arr[], int n)
    {
        int negetiveIndex=n-1;
//        int j=n-1;
        //int i=0;
        for(int i=0;i<n-1;i++){
            for(int j=i;j<n-1;j++){
                if(arr[j]<0 && arr[j+1]>0) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

    }

    public static int missingNumber(int A[], int N)
    {
        int highest=0;
        for(int i: A){
            if(highest<i)
                highest=i;
        }

        int sum1= (N*(N+1))/2;
        int sum=0;
        for(int i: A){
            sum+=i;
        }
        return sum1-sum==0? N+1:sum1-sum;
    }
}
