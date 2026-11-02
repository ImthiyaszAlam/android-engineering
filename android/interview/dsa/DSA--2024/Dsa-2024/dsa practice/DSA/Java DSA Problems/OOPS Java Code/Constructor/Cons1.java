/**
 * Cons1
 */

 class JavaCoding{
    int a = 10;
    int b = 20;
    JavaCoding(int c,int d){
        c = a;
        d = b;
        System.out.println("c: "+c);
        System.out.println("d: "+d);
    }
 }
public class Cons1 {
    public static void main(String[] args) {
        int a = 10;
        int b = 30;
        JavaCoding javaCoding = new JavaCoding(a,b);
        
    }
}