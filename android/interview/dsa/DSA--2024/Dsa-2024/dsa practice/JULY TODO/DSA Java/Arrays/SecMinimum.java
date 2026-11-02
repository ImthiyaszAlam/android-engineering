public class SecMinimum {
    public static void main(String[] args) {
        
        int a[] = {1,10,12,13,115,100};
        int minimum = Integer.MAX_VALUE;
        int secondminimum =Integer.MAX_VALUE;
        for(int i=0;i<a.length;i++){
            if (a[i]<minimum) {
                minimum = a[i];
            }
            if (a[i]>minimum && a[i]<secondminimum) {
                secondminimum = a[i];
            }
        }
        System.out.println("minimum element is: "+minimum);
        System.out.println("second minimum element is: "+secondminimum);
    }
}
