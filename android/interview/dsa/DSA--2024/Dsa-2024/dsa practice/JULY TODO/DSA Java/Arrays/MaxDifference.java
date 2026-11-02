import java.util.Arrays;

public class MaxDifference {
    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int minElement = a[0];
        int maxDifference = a[1]=a[0];
        for(int i=0;i<a.length;i++){
            if (a[i]-minElement >maxDifference) {
                maxDifference = a[i]-minElement;
            }
            if(a[i]-minElement<maxDifference){
                minElement = a[i];
            }
        }
        System.out.println(maxDifference);
    }
}
