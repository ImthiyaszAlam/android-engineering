public class LastOccurence {

    public static int lastOccurence(int arr[], int target, int i) {
        if (i == arr.length) {
            return -1;
        }
        int isFound = lastOccurence(arr, target, i + 1);
        if (isFound != -1) {
            return isFound;
        }
        if (arr[i] == target) {
            return i;
        }
        return isFound;
    }

    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4, 3,5, 6, 7 };
        int target = 3;
        int idx = 0;
        System.out.println(
                lastOccurence(a, target, idx));
    }
}
