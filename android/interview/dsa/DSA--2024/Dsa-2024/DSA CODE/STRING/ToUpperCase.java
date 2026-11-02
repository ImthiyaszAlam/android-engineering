public class ToUpperCase {

    public static String toUppercase(String str){
        StringBuilder sb = new StringBuilder();
        char ch = Character.toUpperCase(sb.charAt(0));

        for(int i=0;i<str.length();i++){
          
            if (str.charAt(i) == ' ' && i<str.length()-1) {
                sb.append(str.charAt(i));
                i++;
                Character.toUpperCase(str.charAt(i));
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
       
    }
    public static void main(String[] args) {
        String str = "I am alam ";
        toUppercase(str);
    
    }
}
