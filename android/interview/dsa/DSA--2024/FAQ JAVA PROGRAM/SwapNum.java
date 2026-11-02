
public class SwapNum {

    // public static void swapTwoNum(int a[]) {
    //     int temp = a[0];
    //     a[0] = a[1];
    //     a[1] = temp;
    // }

    public static void swapTwoNum(int a[]){
        a[0] = a[0]+ a[1];
        a[1] = a[0]-a[1];
        a[0] = a[0]-a[1];
    }
    public static void main(String[] args) {
        int nums[] = {2,4};
        System.out.println("before swapping: "+ nums[0] + " "+nums[1]);
        swapTwoNum(nums);
        System.out.println("after swapping: "+ nums[0] + " "+nums[1]);

    }

}