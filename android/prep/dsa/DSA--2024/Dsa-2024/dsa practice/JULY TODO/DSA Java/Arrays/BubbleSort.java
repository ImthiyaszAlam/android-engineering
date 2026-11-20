public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = { 4,1, 2, 5, 7, 6, 9, 0, 7, 8, 4 };
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];  //4 
                    arr[j] = arr[j+1];  //4 
                    arr[j+1] = temp;
                }
            }
        }

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
