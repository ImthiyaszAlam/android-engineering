public class CountOccurence {

    public static int findFirstOccurence(int[] var0, int var1) {
        int var2 = 0;
        int var3 = var0.length - 1;
        int var4 = -1;

        while (var2 <= var3) {
            int var5 = var2 + (var3 - var2) / 2;
            if (var0[var5] == var1) {
                var4 = var5;
                var3 = var5 - 1;
            } else if (var0[var5] < var1) {
                var2 = var5 + 1;
            } else {
                var3 = var5 - 1;
            }
        }

        return var4;
    }

    public static int findLastOccurence(int[] var0, int var1) {
        int var2 = 0;
        int var3 = var0.length - 1;
        int var4 = -1;

        while (var2 <= var3) {
            int var5 = var2 + (var3 - var2) / 2;
            if (var0[var5] == var1) {
                var4 = var5;
                var2 = var5 + 1;
            } else if (var0[var5] < var1) {
                var2 = var5 + 1;
            } else {
                var3 = var5 - 1;
            }
        }

        return var4;
    }

    public static int findOccurenceCount(int arr[], int target) {
        int first = findFirstOccurence(arr, target);
        int last = findLastOccurence(arr, target);

        if (first == -1 || last == -1) {
            return 0;
        }

        return (last - first )+ 1;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,3,3,3,3,4,5};
        int target = 3;

        System.out.println(findOccurenceCount(arr, target));
    }
}
