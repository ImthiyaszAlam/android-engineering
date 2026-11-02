public class DuplicateArrayElement {
    public static void main(String[] args) {
        String arr[] = {"python","Java","python","c","c++"};


        for(int i=0; i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i] == arr[j]){
                    String duplicate = arr[i];
                    System.out.println("duplicate is "+duplicate);
                }
            }
        }
    }
}
