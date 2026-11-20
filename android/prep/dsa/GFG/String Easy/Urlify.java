public class Urlify {


    public static String urlifyString(String str){
        StringBuilder res = new StringBuilder();
        for(int i=0;i<str.length();i++){
            if (str.charAt(i) == ' ') {
                res.append("%20");
            }else{
                res.append(str.charAt(i));
            }
        }
        return res.toString();
    }
    public static void main(String[] args) {
        String str ="my name is alam";
        System.out.println(urlifyString(str));
    }
}
