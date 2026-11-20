import java.util.Arrays;

public class MinMax {
    public static void main(String[] args) {
        int a [] = {6,1,9,4,0,2,7};
        Arrays.sort(a);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
     
        System.out.println("minimum element is " + a[0] );
        System.out.println("maximum element is "+ a[a.length-1]);
    }
}
