import java.util.HashMap;

public class Subarraysum {

   public void subarraySumMethod(int a[],int targetSum){

    int currentSum = 0;
    int startIndex  = 0;
    int lastIndex =-1;

    HashMap <Integer,Integer> hashMap = new HashMap<>();

    for(int i=0;i<a.length;i++){
        currentSum = currentSum+a[i];
        if (currentSum == targetSum) {
            startIndex = 0; lastIndex = i;
            break;
        }
        if (hashMap.containsKey(currentSum - targetSum)) {
            startIndex = hashMap.get(currentSum - targetSum)+1;
            lastIndex = i;
            break;
        }

        hashMap.put(currentSum, i);
    }

    if (lastIndex == -1) {
        System.out.println("Not found");
    }
    else{
        System.out.println(" start index is "+ startIndex + " & " + "Last index is " + lastIndex);
    }

    }

    public static void main(String[] args) {
        Subarraysum subarraysum = new Subarraysum();
        int a[] = {1,4,20,3,10,5};
        int targetSum = 33;
        subarraysum.subarraySumMethod(a, targetSum);
        
    }
}