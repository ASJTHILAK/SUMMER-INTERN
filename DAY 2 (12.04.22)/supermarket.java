
package supermarket;
import java.util.*;

class Produce {
    static double discount = 0.1;
    static double rate;
    static double offer;
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
    static final String pass = "thilak";
    
    static void bill(String a,String b){
        if("Apple".equalsIgnoreCase(a)){
            Apple obj = new Apple();
            double c = obj.amount(a,b);
            System.out.println("Price of Apple");
            System.out.println(c);
            total += c;
        }
        else if("Orange".equalsIgnoreCase(a)){
            Orange obj = new Orange();
            double c = obj.amount(a,b);
            System.out.println("Price of Orange");
            System.out.println(c);
            total += c;
        }
        else if("Potato".equalsIgnoreCase(a)){
            Potato obj = new Potato();
            double c = obj.amount(a,b);
            System.out.println("Price of Potato");
            System.out.println(c);
            total += c;
        }
        else if("Tomato".equalsIgnoreCase(a)){
            Tomato obj = new Tomato();
            double c = obj.amount(a,b);
            System.out.println("Price of Tomato");
            System.out.println(c);
            total += c;
        }
        else{
            System.out.print(a);
            System.out.println(" is currently not available");
        }
    }
    
    static void change(){
        System.out.println("1. Change the Offer of Apple ");
        System.out.println("2. Change the Offer of Orange ");
        System.out.println("3. Change the Offer of Potato ");
        System.out.println("4. Change the Offer of Tomato ");
        Scanner in= new Scanner(System.in);
        int c = in.nextInt();
        switch(c){
            case 1 :
                Apple obj1 = new Apple();
                System.out.println("Enter the buy and free ");
                Scanner disc1= new Scanner(System.in);
                obj1.discount = disc1.nextDouble();
                obj1.offer = disc1.nextInt();
                break;
            case 2 :
                Orange obj2 = new Orange();
                System.out.println("Enter the discount to be changed ");
                Scanner disc2= new Scanner(System.in);
                obj2.discount = disc2.nextDouble();
                break;
            case 3 :
                Potato obj3 = new Potato();
                System.out.println("Enter the buy and free ");
                Scanner disc3= new Scanner(System.in);
                obj3.discount = disc3.nextDouble();
                obj3.offer = disc3.nextInt();
                break;
            case 4 :
                Tomato obj4 = new Tomato();
                System.out.println("Enter the discount to be changed ");
                Scanner disc4= new Scanner(System.in);
                obj4.discount = disc4.nextDouble();
                break;
        }
    }
    
    public static void main(String[] args) {
        
        while(true){
            System.out.println("1. BUY");
            System.out.println("2. CHANGE DISCOUNT");
            System.out.println("3. Exit");
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
                    break;
                case 2:
                    System.out.println("To change the discounts enter the password");
                    Scanner st= new Scanner(System.in);
                    String password = st.nextLine();
                    if(pass.equals(password)){
                        System.out.println("Password Verified");
                        change();
                    }
                    else{
                        System.out.println("Password Incorrect");
                    }
                    break;
                case 3:
                    break;    
            }
            if(c==3) break;
        }
    }
}
