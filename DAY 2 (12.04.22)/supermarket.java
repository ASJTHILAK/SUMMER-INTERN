
package supermarket;
import java.util.*;

class Produce {
    double discount = 0.1;
    double rate;
    double offer;
}

class Fruits extends Produce{
    Fruits(){
        discount = 0.18;
        if(this.discount>discount){
            discount = this.discount;
        }
    }
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


class Veg extends Produce{
    Veg(){
        discount = 0.05;
        if(this.discount>discount){
            discount = this.discount;
        }
    }
}

class Potato extends Veg {
    Potato(){
        rate = 30;
        discount = 5; // BUY 3
        offer = 2;    // GET 1
    }
    public double amount(String a,String b){
        b = b.replaceAll("\\D","");
        double qt = Double.parseDouble(b);
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

class Tomato extends Veg {
    Tomato(){
        rate = 70;
        discount = 0.1;
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
    static double total =0;
    static String arrayStr[];
    
    static void bill(String a,String b){
        if("Apple".equals(a)){
            Apple obj = new Apple();
            double c = obj.amount(a,b);
            System.out.println("Price of Apple");
            System.out.println(c);
            total += c;
        }
        else if("Orange".equals(a)){
            Orange obj = new Orange();
            double c = obj.amount(a,b);
            System.out.println("Price of Orange");
            System.out.println(c);
            total += c;
        }
        else if("Potato".equals(a)){
            Potato obj = new Potato();
            double c = obj.amount(a,b);
            System.out.println("Price of Potato");
            System.out.println(c);
            total += c;
        }
        else if("Tomato".equals(a)){
            Tomato obj = new Tomato();
            double c = obj.amount(a,b);
            System.out.println("Price of Tomato");
            System.out.println(c);
            total += c;
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
                    for(int i=0;i<(arrayStr.length);i+=2){
                        bill(arrayStr[i],arrayStr[i+1]);
                    }
                    System.out.println("Total amount : "+total);
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
