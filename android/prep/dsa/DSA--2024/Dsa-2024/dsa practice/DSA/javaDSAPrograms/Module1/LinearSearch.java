public class LinearSearch {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8};
        int targetElement  = 5;

        for(int i=0;i<arr.length;i++){
            if (arr[i] == targetElement) {
                System.out.println("Element found :"+arr[i]);
                break;
            }

            System.out.println("Element not found");
        }
    
   
    }
}
