public class ReverseWord {
    public static void main(String[] args) {
        String str = "coding java";
        String [] words = str.split(" ");
        String reversedWord = "";
        String reversedSentence = "";
        for( String word:words){
            for(int i=word.length()-1;i>=0;i--){
                reversedWord = reversedWord+word.charAt(i);
            }
        }
        System.out.println(words);
        reversedSentence = reversedSentence+reversedWord+" ";
        System.out.println(reversedSentence);

    }
}
