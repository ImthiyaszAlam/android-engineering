public class Selectionsort {

    public int selectionSortMethod(int[]a){
        for(int i=0; i<a.length;i++){
            int minIndex = i;

            for(int j=i+1;j<a.length;j++){
                if (a[j]<a[minIndex]) {
                    j = minIndex;
                }
            }

            if (minIndex != i) {
                int temp = a[minIndex];
                a[minIndex] = i;
                a[i] = temp;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Selectionsort selectionsort = new Selectionsort();
        int arr[] = {10,8,12,17,9,17,6};
        int sorted = selectionsort.selectionSortMethod(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+"");
        }
        

        
    }
}