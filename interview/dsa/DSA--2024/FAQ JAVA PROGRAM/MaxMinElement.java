public class MaxMinElement {
    

    public static void largestAndSmallestElement(int a[]){
        int largest = a[0];
        int smallest = a[0];
        for(int i=1;i<a.length;i++){
            if (largest<a[i]) {
                largest = a[i];
            }else if (smallest>a[i]) {
                smallest = a[i];
            }
        }
        System.out.println("largest element is: "+largest);
        System.out.println("smallest element is: "+smallest);
    }
    public static void main(String[] args) {
        int a[] = {12,11,13,11,12,14,15};
        largestAndSmallestElement(a);
    }
}
