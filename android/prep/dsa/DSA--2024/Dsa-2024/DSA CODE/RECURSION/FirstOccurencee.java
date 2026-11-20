public class FirstOccurencee {

    public static int printFirstOccurence(int arr[], int key, int index) {

        if (index == arr.length) {
            return -1;
        }
        if (arr[index] == key) {
            return index;
        }

        return printFirstOccurence(arr, key, index + 1);
    }

    public static void main(String[] args) {
        int arr[] = { 6, 2, 3, 1, 4, 5, 6,1 };
        int key = 1;
        int index = 0;
        System.out.println(
                printFirstOccurence(arr, key, index));
    }
}
