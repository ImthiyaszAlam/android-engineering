public class FirstTwoLargest {
    public static void main(String[] args) {
        int a[] = {10,20,30,40,50,60};
        int firstLargest = a[0];
        int secondLargest = a[0];

        for(int i=0;i<a.length;i++){
            if (firstLargest<a[i]) {
                secondLargest = firstLargest;
                firstLargest = a[i];
            }else if (secondLargest<a[i]) {
                secondLargest = a[i];
            }
        }
        System.out.println("First Largest Element is: "+ firstLargest);
        System.out.println("Second Largest Element is: "+ secondLargest);

    }
}