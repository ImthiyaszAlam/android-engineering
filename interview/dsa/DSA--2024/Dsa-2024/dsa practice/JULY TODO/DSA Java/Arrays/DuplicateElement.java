import java.util.HashSet;
import java.util.Set;

public class DuplicateElement {

//     // public static void findDuplicateElment(int arr[]) {
//     //     for (int i = 0; i < arr.length; i++) {
//     //         for (int j = i + 1; j < arr.length; j++) {
//     //             if (arr[i] == arr[j]) {
//     //                 System.out.print(arr[i] + " ");
//     //             }
//     //         }
//     //     }
//     // }

// using set

public static void findDuplicates(int arr[]){
    Set<Integer> uniqueNumber = new HashSet<>();
    boolean isDuplicate = false;
    for(int i=0;i<arr.length;i++){
        if (uniqueNumber.contains(arr[i])) {
            isDuplicate = true;
            System.out.print( arr[i]+ " ");
        }else{
            uniqueNumber.add(arr[i]);
        }
    }
}
    public static void main(String[] args) {
        int arr[] = { 2, 3, 2, 4, 5, 6, 3 };
        findDuplicates(arr);
        
    }
}
