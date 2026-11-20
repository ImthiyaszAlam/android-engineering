public class TrappingWater {
    public static void main(String[] args) {

        int height[] = {4,2,0,6,3,2,5};
        int n = height.length;
        int leftMax[] = new int[height.length];
        int rightMax[] = new int[height.length];
        
        leftMax[0] = height[0];
        rightMax[n-1] = height[n-1];

        for(int i=1;i<n;i++){
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
            System.out.print(leftMax[i]+" ");
        }

        System.out.println();
        for(int j=n-2;j>=0;j--){
            rightMax[j] = Math.max(height[j], rightMax[j+1]);
            System.out.print(rightMax[j]+" ");
        }
        int trappedWater=0;
        for(int i=0;i<n;i++){
            int  waterLevel = Math.min(leftMax[i], rightMax[i]);
            trappedWater+= waterLevel - height[i];
        }

        System.out.println("trapped water: "+trappedWater);

    }
}
