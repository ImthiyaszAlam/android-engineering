public class SearchElement {

    public static void linearSearch(int target, int arr[]) {
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                System.out.println("element found at index : " + i);
                flag = true;
                break;
            }

        }
        if (flag == false) {

            System.out.println("element not found");
        }

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int target = 5;
        linearSearch(target, arr);
    }
}
