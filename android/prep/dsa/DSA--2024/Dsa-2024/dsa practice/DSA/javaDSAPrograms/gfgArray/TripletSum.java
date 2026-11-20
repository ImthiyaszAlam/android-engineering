import java.util.Arrays;

public class TripletSum {

    public int tripletSumMethod(int[] a) {
        Arrays.sort(a);
        int tripletCount = 0;

        for (int targetSum = a.length - 1; targetSum >= 2; targetSum--) {
            int left = 0;
            int right = targetSum - 1;

            while (left < right) {
                if (a[left] + a[right] == a[targetSum]) {
                    tripletCount++;
                    left++;
                    right--;
                } else if (a[left] + a[right] < a[targetSum]) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return tripletCount;
    }

    public static void main(String[] args) {
        TripletSum tripletSum = new TripletSum();
        int[] a = {2,1,3, 4, 5, 6, 7, 10};
        int totalCount = tripletSum.tripletSumMethod(a);
        System.out.println("total triplet is "+ totalCount);
    }
}
