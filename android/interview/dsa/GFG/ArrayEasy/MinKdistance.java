public class MinKdistance {

    public static boolean minDistance(int arr[], int k) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int distance = j-i;
                if (arr[i] == arr[j] && distance <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,1,4,5};
        int k = 3;
        System.out.println(minDistance(arr, k));
    }
}
