public class BinarySearch {

    public static void binarySearch(int target,int a[]){
        int lowerValue = 0;
        int higherValue = a.length-1;
        int mid = (lowerValue+higherValue)/2;

        boolean flag = false;
        while (lowerValue<=higherValue) {
            if (a[mid] == target) {
                flag = true;
                System.out.println("element found");
                break;
            }else if (target<a[mid]) {
                higherValue = mid-1;
            }else if (target>a[mid]) {
                lowerValue = mid+1;
            }
        }
        if (flag == false) {
            System.out.println("element not found in array");
        }
    }
    public static void main(String[] args) {
        
    }
}
