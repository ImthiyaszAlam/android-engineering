public class SquareRootWithPrecision {
    public static void main(String[] args) {
        int N = 8;
        int precision = 3;
        System.out.println(findSuareWithPrecision(N, precision));
    }

    public static double findSuareWithPrecision(int N, int precision) {
        int low = 0;
        int high = N;
        double ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid * mid == N) {
                return mid;
            } else if (mid * mid < N) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        double increment = 0.1;

        for (int i = 0; i < precision; i++) {
            while (ans*ans <= N) {
                ans += increment;
            }
            ans -= increment;
            increment /= 10;
        }

        return ans;

    }
}
