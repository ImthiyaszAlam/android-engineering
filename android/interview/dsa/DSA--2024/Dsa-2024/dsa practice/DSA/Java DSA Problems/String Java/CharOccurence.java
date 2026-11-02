import java.util.Arrays;

public class CharOccurence {
    public static void main(String[] args) {
        String str = "opentext";
        char charToReplace = 't';
        int index = str.indexOf(charToReplace);
        if (index == -1) {
            System.out.println("Given char is not available in string");
            System.exit(0);
        }
        char [] charArray = str.toCharArray();
        int count=1;
        for(int i=0;i<charArray.length;i++){
            if (charArray[i] == charToReplace) {
                charArray[i] = String.valueOf(count).charAt(0);
                count++;
            }
        }
    System.out.println(charArray);

        }
    }

