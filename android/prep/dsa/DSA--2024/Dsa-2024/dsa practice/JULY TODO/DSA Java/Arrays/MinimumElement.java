import java.util.Arrays;
import java.util.Scanner;

public class MinimumElement {

    
public static void findMinElement(int a[]){
    int minElement = a[0];
    for(int i=0;i<a.length;i++){
        if (minElement>a[i]) {
            minElement = a[i];
        }
    }
    System.out.println("minElement is: "+minElement);
}






    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter array length");
        int arrayLength = sc.nextInt();
        int arr[] = new int[arrayLength];
        System.out.println("Enter an element");
        for (int i = 0; i < arrayLength; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));

        findMinElement(arr);


    }
}
