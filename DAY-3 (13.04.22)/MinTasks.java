
package mintasks;

interface inheritance{
    default void print(){
        System.out.println("Default interface first");
    }
}

interface heritance extends inheritance{
    default void show(){
        System.out.println("Default interface second");
    }
}

abstract class abs1{
    static int num= 'a'; //It is final variable by default
    abs1(){
        System.out.println("abs1 Constructor is Called");
    }
    abstract void meth(); //abstract class should contain minimum one abstract class
    abstract int meth(int a); //method overloading
    
    static final void fun(){
        System.out.println("ascii value of a is "+num);
    }
}
    
abstract class abs2{
    
    abs2(){
        System.out.println("abs2 Constructor is Called"); //It won't print since we didn't create a object for it
    } 
    
    static void meth2(){
        System.out.println("meth2 static method is Called using method ");
    }    
    
}

class normal extends abs1{
    
    normal(){
        System.out.println("normal Constructor is Called");
    }

    @Override
    void meth(){
        System.out.println("meth method is called");
    }
    
    @Override
    int meth(int a){
        System.out.println("Method overiding and overloading by method argument "+a);
        return a*(-1);
    }
}

class stringTypes{
    
    public static void concat(String s1)
    {
        s1 = s1 + " SUPER KINGS";
    }
 
    protected static void concat(StringBuffer s2)
    {
        s2.append(" SUPER KINGS");
    }
    
    private static void concat(StringBuilder s3)
    {
        s3.append(" SUPER KINGS");
    }
    
    static void callPrivate(StringBuilder s3){
        concat(s3);
        System.out.println("Private method is called by another method inside the class");
    }
}

public class MinTasks implements heritance,inheritance {
    
    
    public static void main(String[] args) {
        
        abs1 obj = new normal();
        obj.meth();
        int ans = obj.meth(2);
        System.out.println("Negative value "+ans);
        abs2.meth2(); //staic method is called by class name
        abs1.fun(); //static final method is called by class name
        abs1.num = 'b'; //final variable can't be changed
        
        try{
            abs obj = new abs();  //Objects can't be created for Abstract class
        }
        catch(Exception e){
            System.out.println("Objects can't be created for Abstract class");
        }
        finally{
            System.out.println("Finally is used after exception handling");
        }
        
        MinTasks obj1 = new MinTasks();
        obj1.show();
        obj1.print();
        
        //String
        String s1 = "CHENNAI";
        stringTypes.concat(s1);
        System.out.println("String: " + s1);
 
        //StringBuffer
        StringBuffer s2 = new StringBuffer("CHENNAI");
        stringTypes.concat(s2);
        System.out.println("StringBuffer: " + s2);
        
        //StringBuilder
        StringBuilder s3 = new StringBuilder("CHENNAI");
        //stringTypes.concat(s3); // The Method won't be called since it is Private
        stringTypes.callPrivate(s3);
        System.out.println("StringBuilder: " + s3);
        
    }
}
