
package supermarket;
import java.util.*;

class Fruits {
    double rate;
    double discount = 0.18;
    double offer;
    public void print_A() { System.out.println("Class A"); }
}
 
class Apple extends Fruits {
    Apple(){
        rate = 50;
        discount = 3; // BUY 3
        offer = 1;    // GET 1
    }
    public double amount(String a,String b){
        b = b.replaceAll("\\D","");
        double qt = Double.parseDouble(b);
        System.out.println(qt);
        if(qt==discount){
            return rate*qt;
        }
        double count = discount;
        while(count<qt){
            qt = qt-offer;
            count = count + discount;
        }
        double sum = (rate*qt);
        return sum;
    }
}

class Orange extends Fruits {
    Orange(){
        rate = 80;
        discount = 0.2;
        if(this.discount>discount){
            discount = this.discount;
        }
    }
    public double amount(String a,String b){ 
        b = b.replaceAll("\\D","");
        double qt = Double.parseDouble(b);
        double sum = (rate*qt)-(rate*qt*discount);
        return sum;
    }
}

public class Supermarket {
    
    static String arrayStr[];
    
    static void bill(String a,String b){
        if("Apple".equals(a)){
            Apple obj = new Apple();
            double c = obj.amount(a,b);
            System.out.println("Price of Apple");
            System.out.println(c);
        }
        else if("Orange".equals(a)){
            Orange obj = new Orange();
            double c = obj.amount(a,b);
            System.out.println("Price of Orange");
            System.out.println(c);
        }    
    }
    
    public static void main(String[] args) {
        
        System.out.println("1. BUY");
        System.out.println("2. CHANGE DISCOUNT");
        System.out.println("3. Exit");
        while(true){
            Scanner in= new Scanner(System.in);
            int c = in.nextInt();
            switch(c){
                case 1 :
                    System.out.println("Enter the items to be bought : ");
                    Scanner sc= new Scanner(System.in);
                    String str = sc.nextLine();
                    arrayStr = str.split("[ ,]+");
                    for(int i=0;i<(arrayStr.length)/2;i+=2){
                        bill(arrayStr[i],arrayStr[i+1]);
                    }
                    continue;
                case 2:
                    break;
                case 3:
                    break;    
            }
            if(c==3) break;
        }
    }
}
