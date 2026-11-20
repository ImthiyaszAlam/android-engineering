import java.util.Arrays;

public class EqualArray {
    public static void main(String[] args) {
        int arr1[] = {1,2,3,4,5,6,7,8};
        int arr2[] = {1,2,3,4,5,6,7,8};


        boolean staus =     Arrays.equals(arr1, arr2);
        if (staus ==true) {
            System.out.println("Arrays are equal");
        }
        else{
            System.out.println("Arrays Not Equal");
        }
    }
}
