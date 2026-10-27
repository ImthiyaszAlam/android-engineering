import java.util.ArrayList;

public class SubarraySum {

    public static ArrayList<ArrayList<Integer>> subArraySum(int arr[]) {
        ArrayList<ArrayList<Integer>> resuList = new ArrayList<>();

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j <= arr.length; j++) {

                ArrayList<Integer> subArray = new ArrayList<>();
                for (int k = i; k < j; k++) {
                    subArray.add(arr[k]);
                    sum+=arr[k];
                }
                resuList.add(subArray);
            }
        }

        System.out.println(sum);
        return resuList;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 ,4,5,6};
        System.out.println(subArraySum(arr));
    }
}
