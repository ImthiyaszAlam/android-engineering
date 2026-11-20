public class SwapNum {
    public static void main(String[] args) {
        int a = 5;
        int b = 6;

        System.out.println("Before swapping :" + a + "&" + b);

        int c = a;
        a = b;
        b = c;

        System.out.println("After swapping :" + a + "&" + b);

        // b6 & a5
        int d = a; // d = 6
        a = b; // a = 6
        b = d; // b = 5

        System.out.println("After Second swapping :" + a + "&" + b);

        int y = 10;
        int z = 15;

         System.out.println("Before swap: y & z  :" + y + " " + z);

        y = y + z;   //15
        z = y - z;   //-5
        y = y - z;   // 10

        System.out.println("After swap: y & z  :" + y + " " + z);

    }
}
