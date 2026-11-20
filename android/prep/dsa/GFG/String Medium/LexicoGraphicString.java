public class LexicoGraphicString {

    static String nmextString(String str){
        int i = str.length()-1;
        while (i>=0 && str.charAt(i)=='z') {
            i--;
        }

        if (i==-1) {
            return str+'a';
        }

        char [] charArray = str.toCharArray();
        charArray[i]++;

        return new String(charArray,0,i+1);
    }
    public static void main(String[] args) {
        
    }
}
