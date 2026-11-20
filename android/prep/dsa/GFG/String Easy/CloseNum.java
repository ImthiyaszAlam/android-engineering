public class CloseNum {

    public static String convertToCamelCase(String str) {
        StringBuilder sBuilder = new StringBuilder();

        boolean capitalizeText = false;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                capitalizeText = true;
            } else if (capitalizeText == true) {
                sBuilder.append(Character.toUpperCase(str.charAt(i)));
                capitalizeText = false;
            } else {
                sBuilder.append(str.charAt(i));
            }
        }

        return sBuilder.toString();
    }

    public static void main(String[] args) {
        String str = "i got intern at geeksforgeeks";
        System.out.println(convertToCamelCase(str));

    }
}
