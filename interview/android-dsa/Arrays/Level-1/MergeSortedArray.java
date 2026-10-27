public class MergeSortedArray {

    public static void mergeSortedArr(int nums1[], int m, int nums2[], int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        while (j >= 0) {
            nums1[k] = nums2[j];
            i--;
            k--;
        }
    }

    public static void main(String[] args) {

        int nums1[] = { 1, 3, 0, 0, 0 };
        int nums2[] = { 1, 2, 3 };
        int m = 2;
        int n = 3;
        mergeSortedArr(nums1, m, nums2, n);

        int k = m + n;
        for (int i = 0; i < k; i++) {
            System.out.print(nums1[i] + " ");
        }

    }
}
