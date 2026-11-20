public class RemoveChar {

    public static String removeChar(String str, int index) {
        StringBuilder sBuilder = new StringBuilder(str);
        sBuilder.deleteCharAt(index);
        return sBuilder.toString();

    }

    public static void main(String[] args) {
        String str = "alam";
        int index = 2;
        System.out.println(removeChar(str, index));
    }
}
