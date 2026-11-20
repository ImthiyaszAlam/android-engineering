public class secondLargest {
    public static void main(String[] args) {
        int largest = Integer.MAX_VALUE;
        int secondLargest = Integer.MAX_VALUE;
        int arr[] = {99,10,40,5,60,7,8,9};
        for(int i=0;i<arr.length;i++){
            if (arr[i]<largest) {
                secondLargest = arr[i];
            }
            if (arr[i]>largest && arr[i]>secondLargest) {
                secondLargest = arr[i];
            }
        }
        System.out.println("largest element is :"+largest);
        System.out.println("second largest element is :"+secondLargest);
    }
}

// Incorrect Logic
