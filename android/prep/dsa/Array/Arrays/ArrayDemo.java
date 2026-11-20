class ArrayDemo{
    public static void main(String[] args) {
        int numbers[] = {1,2,3,4,5,6,7,8,9,0};
        System.out.println("first element is :"+numbers[0]);
        System.out.println("last element is :"+numbers[numbers.length-1]);

        numbers[1] = 20;
        System.out.println("modified element is: "+numbers[1]);

        System.out.println("AlL Elements");
        for(int i=0;i<numbers.length;i++){
            System.out.print(numbers[i]+" ");
        }
    }
}