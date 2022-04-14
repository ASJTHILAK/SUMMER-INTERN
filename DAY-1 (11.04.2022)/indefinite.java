
import java.util.*;

public class indefinite {

    public static void main(String[] args) {

//        int n = Integer.MAX_VALUE;
//        int arr[];
//        arr = new int[n];

        int size1 = 1; //size of array one
        int size2 = 0; //size to be added to array two
        
        int array1[] = new int[size1];
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        
        while (x != -1) {
            if (size2 == array1.length) {
                int array2[] = new int[size1 + size2];
                System.arraycopy(array1, 0,array2, 0, array1.length);  //Copy from one array to another
            
//              for (int i = 0; i < arr.length; i++) {
//                  brr[i] = arr[i];
//              }
                array1 = array2;
            }
            array1[size1 - 1] = x;
            x = in.nextInt();
            size1++;       
            size2++;  
        }
        
        //printing the elements of the array
        
        for (int i = 0; i < (size1+size2)/2 ; i++) {
            //if(array1[i] == null) break;
            System.out.print(array1[i]);
            System.out.println();
        }
    }
}

