public class SecondMini {
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,7};
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for(int i=0;i<a.length;i++){
            if (a[i]<smallest) {
                secondSmallest = smallest;
                smallest = a[i];
            }else if (a[i]<smallest && a[i] !=smallest) {
                secondSmallest = a[i];
            }
        }
        if (secondSmallest == Integer.MAX_VALUE) {
            System.out.println("no value found");
        }else{
            System.out.println("second smallest"+secondSmallest);
        }
        System.out.println("smallest: "+smallest);

    }
}
