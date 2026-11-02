public class SecondSmallest {
    public static void main(String[] args) {
        int a[] = {-1,7,1,34,18};
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for(int i=0;i<a.length;i++){
            if (a[i]<smallest) {
                smallest = a[i]; // -1,
            }
            if(a[i]>smallest && a[i]<secondSmallest){
                secondSmallest = a[i];
            }
        }
        System.out.println("smallest is "+smallest);
        System.out.println("second smallest is "+secondSmallest);
    }
}
