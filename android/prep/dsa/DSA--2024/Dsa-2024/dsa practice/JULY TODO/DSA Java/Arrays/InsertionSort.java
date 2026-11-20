public class InsertionSort {
    public static void main(String[] args) {
        int a[] = {3,1,5,4,8,6};
        for(int i=0;i<a.length;i++){
            int currentElement = a[i];
            int j=i-1;
            while (j>=0 && currentElement<a[j]) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = currentElement;

        }
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]+" ");
        }
        
    }
}
