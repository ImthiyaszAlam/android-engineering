public class ReverseString {
    public static void main(String[] args) {

        StringBuilder result = new StringBuilder();
        String str = "alam";
        for(int i=str.length()-1;i>=0;i--){

            result.append(str.charAt(i));
        }
        System.out.println(result);

    }
}
