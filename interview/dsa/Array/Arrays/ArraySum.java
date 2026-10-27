public class ArraySum {
    public static void main(String[] args) {
        int number[] = {1,2,3,4,5};
        int sum = 0;
        for(int i=0;i<number.length;i++){
            sum+=number[i];
        }
        System.out.println("sum of all elements in array number is : "+sum);
    }
}
