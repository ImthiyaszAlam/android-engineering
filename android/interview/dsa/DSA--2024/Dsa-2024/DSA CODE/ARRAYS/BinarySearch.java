public class BinarySearch {

    public static int binarySearch(int numbers[], int target) {
        int start = 0;
        int end = numbers.length;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == numbers[mid]) {
                return mid;
            } else if (target < numbers[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int num[] = {2,3,4,6,8,9};
        int target = 8;
        System.out.println("index for target element is: "+binarySearch(num, target));
    }
}
