
public class ClosestSum {

    public static void printClosestSum(int arr1[], int arr2[], int target) {
    
        int closestNum1 = 0;
        int closestNum2 = 0;
        int minDifference = Integer.MAX_VALUE;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                int sum = arr1[i] + arr2[j];
                int absoluteDifference = Math.abs(sum - target);
                if (absoluteDifference < minDifference) {
                    minDifference = absoluteDifference;
                    closestNum1 = arr1[i];
                    closestNum2 = arr2[j];
                }
            }
        }
        System.out.println( "Pair:   "  +closestNum1 +"  "+ closestNum2);
        System.out.println("min difference   :   "+minDifference);
    }


    public static void printClosest(int arr1[],int arr2[],int target){


        int minDifference = Integer.MAX_VALUE;
        int l1 = arr1.length;
        int l2  = arr2.length;

        int i=0;
        int j = l2-1;

        int res1 = 0;
        int res2 = 0;

        while (i<l1 && j>=0) {
            int currentSum = arr1[i]+arr2[j];
            int currentDifference = Math.abs(currentSum-target);
            if (currentDifference<minDifference) {
                minDifference = currentDifference;
                res1 = arr1[i];
                res2 =arr2[j];
                if (currentDifference<target) {
                    i++;
                }else{
                    j--;
                }
            }
        }
        System.out.println(res1+" "+res2);
        System.out.println("mi difference is : "+minDifference);


    }

    
    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int b[] = { 10, 11, 12, 14, 15 };
        int target = 30;
        printClosest(a, b, target);
    }
}