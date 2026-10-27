public class VowelNumbers {
    public static void main(String[] args) {
        String str = "alamaaa";
        int vowelCount = 0;
        char[] charArray = str.toCharArray();
        for(char ch:charArray){
            switch (ch) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    vowelCount++;
                    System.out.print(ch+" ");
                    break;      
            }
        }
        System.out.println("total vowel in "+ str+" is: "+vowelCount);
    }
}
