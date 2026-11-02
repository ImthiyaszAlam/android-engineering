public class MinCost {

    static void totalCost(int arr[],int n){
        int smallestElement = arr[0];


        for(int i=0;i<arr.length-1;i++){
            if (arr[i]<smallestElement) {
                smallestElement = arr[i];
            }
        }

        System.out.println(n*(smallestElement));
    }
    public static void main(String[] args) {

        int arr[] = {2,2,3,4,5,6,7,8,9,10};
        totalCost(arr, arr.length);
        
    }
}
