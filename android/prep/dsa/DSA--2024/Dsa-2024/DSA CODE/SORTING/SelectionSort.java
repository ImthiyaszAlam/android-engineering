public class SelectionSort {

    public static void selectionSort(int a[]) {
        for (int i = 0; i < a.length; i++) {
            int minPosition = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[minPosition] < a[j]) {
                    minPosition= j;
                }
            }
            int temp = a[minPosition];
            a[minPosition] = a[i];
            a[i] = temp;
        }
        
    }

    public static void printArray(int a[]){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }

    public static void main(String[] args) {
        int a[] = {3,1,5,4,2};
        selectionSort(a);
        printArray(a);
    }
}
