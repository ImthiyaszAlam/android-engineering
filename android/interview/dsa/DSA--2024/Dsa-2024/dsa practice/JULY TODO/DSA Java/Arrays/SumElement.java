public class SumElement {
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,7};
        int targetSum = 8;
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                if (a[i]+a[j] ==targetSum) {
                    System.out.println(a[i] +" "+ a[j]);
                }
            }
        }
    }
}
