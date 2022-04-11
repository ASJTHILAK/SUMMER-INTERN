
import java.util.*;

public class indefinite {

    public static void main(String[] args) {

//        int n = Integer.MAX_VALUE - 4;
//        int arr[];
//        arr = new int[n];

        int i = 1;
        int j = 0;
        int arr[] = new int[i];
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        
        while (x != -1) {
            if (j == arr.length) {
                int brr[] = new int[i + j];
                for (int z = 0; z < j; z++) {
                    brr[z] = arr[z];
                }
                arr = brr;
            }
            arr[j] = x;
            x = in.nextInt();
            i++;
            j++;
        }

        for (int q = 0; q < arr.length; q++) {
            if(arr[q]==0) break;
            System.out.print(arr[q]);
            System.out.println();
        }
    }
}
