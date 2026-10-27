/**
 * Merge2Arrays
 */
public class Merge2Arrays {

    public static int[] merge2Arrays(int arr1[], int arr2[]) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int resulatntArray[] = new int[len1 + len2];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < len1 && j < len2) {
            if (arr1[i] < arr2[j]) {
                resulatntArray[k++] = arr1[i++];
            } else {
                resulatntArray[k++] = arr2[j++];
            }
        }
        while (i < len1) {
            resulatntArray[k++] = arr1[i++];
        }
        while (j < len2) {
            resulatntArray[k++] = arr2[j++];
        }
        return resulatntArray;
    }

    public static void main(String[] args) {
        int a1[] = { 1, 20, 3, 4, 5 };
        int a2[] = { 16, 70, 8, 9, 10 };
        int[] resulatntArray = merge2Arrays(a1, a2);
        merge2Arrays(a1, a2);
        for (int i : merge2Arrays(a1, a2)) {
            System.out.print(i + " ");
        }

    }
}