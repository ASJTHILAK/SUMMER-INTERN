
package taskbar;
import java.util.*;
public class Taskbar {
    
    static void addTask(String arr[][]){
        System.out.println("Enter the Name: ");
        Scanner sc= new Scanner(System.in);
        String name= sc.nextLine();
        if(arr[0][0] == null){
            arr[0][0]= name;
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(name.equals(arr[i][j])){
                    System.out.println("Enter the tasks: ");
                    Scanner in= new Scanner(System.in);
                    String task= in.nextLine();
                    if(arr[i][j+1] == null){
                        arr[i][j+1] = task; 
                       return;
                    }
                    else{
                        while(arr[i][j+1]!=null){
                            j++;
                        }
                        arr[i][j+1] = task;
                        return;
                    }
                }
            }
        }
        
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                while(arr[i][j] != null){
                    i++;
                }
                arr[i][j]= name;
                System.out.println("Enter the tasks: ");
                Scanner in= new Scanner(System.in);
                String task= in.nextLine();
                if(arr[i][j+1] == null){
                    arr[i][j+1] = task;
                    return;
                }
                else{
                    while(arr[i][j+1]!=null){
                        j++;
                    }
                    arr[i][j+1] = task;
                    return;
                }
            }
        }    
    }
    
    static void viewTask(String arr[][]){
        System.out.println("Enter the Name: ");
        Scanner sc= new Scanner(System.in);
        String name= sc.nextLine();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(name.equals(arr[i][j])){
                    while(arr[i][j]!=null){
                        if(arr[i][j] == null) return;
                        System.out.println(arr[i][j+1]);
                        j++;
                    }
                }
                else{
                    break;
                }
            }
        }
    }
    
    static void viewAllTask(String arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(arr[i][j] == null) continue;
                System.out.println(arr[i][j]);
            }
            if(arr[i][0] == null) break;
            System.out.println("---------------------------------");
        } 
    }
    
    public static void main(String[] args) {
        String[][] arr = new String[100][100];
        while(true){
            System.out.println("1. To add task");
            System.out.println("2. To view task of specific user");
            System.out.println("3. To view all task");
            System.out.println("4. To Exit");
             
            Scanner in = new Scanner(System.in);
            int c = in.nextInt(); 
            switch (c){
                case 1 :
                    addTask(arr);
                    break;
                case 2 :
                    viewTask(arr);
                    break;
                case 3 :
                    viewAllTask(arr);
                    break;
                case 4 :
                    break;
                default :
                    System.out.println("Enter correct input : ");
                    break;
            }
            if(c==4) break;
        }
    }
}    

//arr = Arrays.copyOf(arr,arr.length+1);

 
