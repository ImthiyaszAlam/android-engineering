public class TrappingRainWater {

    public static int trappedWater(int height[]) {
        // calculate left max bounadry
        int leftMax[] = new int[height.length];
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        // calculate right max bounadry
        int rightMax[] = new int[height.length];
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        // extract water level;
        // trapped water
        int trappedWater = 0;
        for (int i = 0; i < height.length; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trappedWater += waterLevel - height[i];

        }
        return trappedWater;
    }

    public static void main(String[] args) {
        int a[] = { 4, 2, 0, 6, 3, 2, 5 };
        System.out.println(trappedWater(a));
    }
}
