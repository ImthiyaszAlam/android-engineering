public class ReverseWord {
    public static void main(String[] args) {
        String str = "Welcome to Anna";
        String splitArray[] = str.split(" ");
        int strLen = splitArray.length;
        for(int i=strLen-1;i>=0;i--){
            System.out.println(splitArray[i]);
        }
    }
}
