import java.util.Arrays;

public class AnagramWoDelection {

    static int minManipulation(String s1, String s2) {
        char arr1[] = s1.toCharArray();
        char arr2[] = s2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int i = 0;
        int j = 0;
        int count = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
                count++;
            } else {
                j++;
                count++;
            }
        }

        while (i < arr1.length) {
            i++;
            count++;
        }

        while (j < arr2.length) {
            j++;
            count++;
        }

        return count / 2;
    }

    public static void main(String[] args) {
        String s1 = "ddcf";
        String s2 = "cedk";
        System.out.println(minManipulation(s1, s2));
    }
}
