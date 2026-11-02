public class removeArrayElement {

    public static void removeElement(int[] array,int element){
        int newArray[] = new int[array.length-1];
        int index = 0;

        for(int i=0;i<=array.length;i++){
            if (array[i]!=element) {
                newArray[index] = array[i];
                index++;
            }
        }

    }
    public static void main(String[] args) {
        int arr1[] = {1,2,3,4,5,6,7,8,9};
        int elementToRemove  = 5;

    }
}
