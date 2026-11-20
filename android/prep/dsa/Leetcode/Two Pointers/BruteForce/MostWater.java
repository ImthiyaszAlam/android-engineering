public class MostWater {

    public static int findMaxWaterArea(int numbers[]) {
        int maxArea = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int area = Math.min(numbers[i], numbers[j]) * 1;
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;

    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4, 5, 6, 7 };
        System.out.println(findMaxWaterArea(nums));
        ;
    }
}