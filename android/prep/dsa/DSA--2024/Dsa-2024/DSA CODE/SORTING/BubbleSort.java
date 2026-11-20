
public class BubbleSort {
    public static void bubbleSorting(int a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    public static void printArray(int a[]){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }

    public static void main(String[] args) {
        int a[] = {4,2,6,5,7,8,1,12,14,13};
        bubbleSorting(a);
        printArray(a);
    }

}