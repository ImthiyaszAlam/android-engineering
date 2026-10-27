public class RotateArray {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int d = 2;
        rotateArray(arr, d);

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+",");
        }
    }



    public static void rotateArray(int [] arr,int d){
        int n = arr.length;


        for(int i=0;i<d;i++){
            int last = arr[n-1];

            for(int j=n-1;j>0;j--){
                int secondLastElement = arr[j-1];
                arr[j] =secondLastElement;
            }
            arr[0]= last;
        }
    }
}
