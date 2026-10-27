import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals56 {

    public static int[][] mergeOverLappingIntervals(int[][] intervals) {
        int n = intervals.length;
        if (n <= 1)
            return intervals;

        boolean merged[] = new boolean[n];
        List<int[]> result = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for (int i = 0; i < n; i++) {

            if (merged[i]) {
                continue;
            }
            int start = intervals[i][0];
            int end = intervals[i][1];

            for (int j = i + 1; j < n; j++) {
                int secondEnd = intervals[j][1];
                int secondStart = intervals[j][0];
                if (secondStart <= end) {
                    end = Math.max(end, secondEnd);
                    merged[j] = true;
                } else {
                    break;
                }
            }
            result.add(new int[] { start, end });
        }
        return result.toArray(new int[result.size()][]);

    }

    public static void main(String[] args) {
        int intervals[][] = {{1,3}, {2,6}, {8,10}, {15,18}};
        int[][] mergedIntervals = mergeOverLappingIntervals(intervals);

        for (int[] interval : mergedIntervals) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
