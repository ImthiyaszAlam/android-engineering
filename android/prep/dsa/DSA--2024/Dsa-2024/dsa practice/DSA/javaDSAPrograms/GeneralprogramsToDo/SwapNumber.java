public class SwapNumber {



    public void swapNumberMethod(int a []){
        int temp = a[0];
        a[0] = a[1];
        a[1] = temp;
    }

    public static void main(String[] args) {
        SwapNumber swapNumber = new SwapNumber();
        int a [] = {5,10};
        System.out.println("before swapping : " + a[0] + " " + a [1]);
        swapNumber.swapNumberMethod(a);
        System.out.println("after swapping : " + a[0] + " " + a [1]);

        
    }
}