public class SortedArray {


    public static boolean isArraySorted(int a[]){
        int arrLen = a.length;
        for(int i=1;i<arrLen-1;i++){
            if (a[i]>=a[i-1]) {
            }else{
                return false;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int a[] = {2,1,3,2,14,13,12,156,10};
        boolean result  = isArraySorted(a);
        System.out.println(result);
    }
}
