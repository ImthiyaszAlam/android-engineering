public class SquareRootBinarySearch {
    public static void main(String[] args) {
        System.out.println(finfFloorSquare(20));
    }


    public static int finfFloorSquare(int N){
        int low = 0;
        int high = N;
        int ans = -1;

        while (low<high) {
            int mid = low+(high-low)/2;

            if (mid*mid == N) {
                return mid;
            }else  if (mid*mid<=N) {
                ans = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return ans;
    }
}
