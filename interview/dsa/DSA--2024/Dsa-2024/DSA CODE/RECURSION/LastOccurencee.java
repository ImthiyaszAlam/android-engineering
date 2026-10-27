public class LastOccurencee {

    public static int printLastOccurence(int arr[], int key, int index) {
        if (index == 0) {
            return -1;
        }

        if (arr[index] == key) {
            return index;
        }

        return printLastOccurence(arr, key, index - 1);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 1 };
        int key = 1;
        int index = arr.length - 1;
        System.out.println(printLastOccurence(arr, key, index));

    }
}
