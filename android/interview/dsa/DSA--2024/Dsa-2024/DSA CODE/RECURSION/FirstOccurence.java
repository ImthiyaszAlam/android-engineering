public class FirstOccurence {

    public static int printFirstOccurence(int a[],int target,int i){
        if (i == a.length) {
            return -1;
        }
        if (a[i] == target) {
            return i;
        }
        return printFirstOccurence(a, target, i+1);
        }
    
    public static void main(String[] args) {
        int arr[] = {1,2,3,5,4,5,6};
        int target = 5;
        int idx = 1;
        System.out.println(printFirstOccurence(arr, target, idx));
    }
}
