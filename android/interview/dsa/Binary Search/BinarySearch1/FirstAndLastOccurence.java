public class FirstAndLastOccurence {
    public static void main(String[] args) {
        int numbers[] = {1,2,2,2,2,3,4,5,6,7,8};
        int target = 2;

        System.out.println(findFirstOccurence(numbers, target));
        System.out.println(findLastOccurence(numbers, target));
    }

    public static int findFirstOccurence(int arr[], int target) {
        int start = 0;
        int end = arr.length - 1;
        int first = -1;

        while (start <= end) {
            int mid = start + (end-start) / 2;
            if (arr[mid] == target) {
                first = mid;
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return first;
    }

    public static int findLastOccurence(int arr[], int target) {
        int left = 0;
        int right = arr.length - 1;
        int last = -1;

        while (left <= right) {
            int mid = left + (right-left) / 2;
            if (arr[mid] == target) {
                last = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return last;
    }

}