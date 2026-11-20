public class MaxElement {
    public static void main(String[] args) {
        int a[] = {10,20,30,40,25,35,45};
        int maxElement = a[0];
        for(int i=0;i<a.length;i++){
            if (a[i]>maxElement) {
                maxElement = a[i];
            }
        }
        System.out.println(maxElement);
    }
}
