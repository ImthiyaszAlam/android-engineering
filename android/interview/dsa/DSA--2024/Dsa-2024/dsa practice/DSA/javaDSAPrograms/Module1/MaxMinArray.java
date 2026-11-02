public class MaxMinArray {
    public static void main(String[] args) {
        int arr[] = {20,10,15,25,30,23};
        int max = arr[0];
        int min = arr[0];

        for(int i=0; i<arr.length;i++){
            if (arr[i]>max) {
                max = arr[i];
            }
        }

        System.out.println("Maximum value is "+max);

        
        for(int i=0; i<arr.length;i++){
            if (arr[i]<min) {
                min = arr[i];
            }
        }

        System.out.println("Maximum value is "+min);
    }
}
