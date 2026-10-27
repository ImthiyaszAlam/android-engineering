public class Largest3Num {

    public static int  largestNum(int a,int b,int c){
        int largest = a>b?a:b;
        largest = b>c?b:c;
        largest = a>c?a:c;
        return largest;
    }
    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        int c = 15;
        System.out.println(largestNum(a, b, c));
    }
}
