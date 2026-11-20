import java.util.*;

public class reverseVowel {


    public static boolean isVowel(char c){
        return c == 'a'|| c == 'e'|| c == 'i'|| c == 'o'|| c == 'u'||
        c == 'A'||c == 'E'||c == 'I'||c == 'O'||c == 'U';
    }
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a String");
    String input = sc.nextLine();

    char charArray[] = input.toCharArray();
    int start = 0;
    int end = charArray.length-1;

    while (start<end) {
        if (isVowel(charArray[start] ) && isVowel(charArray[end])) {
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++;
            end--;
        }else if (isVowel(charArray[start])) {
            end--;
        }else if (isVowel(charArray[end])) {
            start++;
        }else{
            start++;
            end--;
        }

    }
    for(int i=0; i<charArray.length; i++){
        System.out.print(charArray[i]);
    }

}
}

