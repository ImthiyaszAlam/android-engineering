public class FirstLastPosition {

    public static void findBound(){

    }   
     
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,4,5};
        int target = 4;
        int start = 0;
        int end = arr.length-1;

        while (start<end) {
            if (arr[start] == target) {
                System.out.print("first index : "+start);
            }

            System.out.println();

            if (arr[end] == target) {
                System.out.print("last index: "+end);
            }

            start++;
            end--;
        }
    }
}
