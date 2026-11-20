import java.util.Scanner;

/**
 * DuplicateElement
 */
public class DuplicateElement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       System.out.println("Enter size of array");
       int arraySize = sc.nextInt();
       int array1[] = new int[arraySize];
       for(int i=0;i<arraySize;i++){
        array1[i] = sc.nextInt();
       }
       
       for(int i=0;i<arraySize;i++){
        for(int j=i+1;j<arraySize;j++){
            if (array1[i] == array1[j]) {
                System.out.println("Duplicate element is : "+array1[i]);
            }
        }
        
       }
    
    }
}