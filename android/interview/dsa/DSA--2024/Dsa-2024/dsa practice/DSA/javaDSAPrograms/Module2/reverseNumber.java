public class reverseNumber {
    public static void main(String[] args) {
        int [] array = {1,2,3,4,5,6,7,8};
        int newArray[] =new int[array.length];
        for(int i=array.length-1,j=0;i>=0;i--,j++){
            newArray[j] = array[i];
        }
        System.out.println(newArray);
    }
}
