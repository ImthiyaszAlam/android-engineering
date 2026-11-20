public class Substring {

    public static String printSubString(String str,int si,int ei){
        String substr = "";
        for(int i=si;i<ei;i++){
            substr+=str.charAt(i);
        }
        return substr;
    }
    public static void main(String[] args) {
        String str = "annaHere";
      System.out.println(  str.substring(0, 5));
        System.out.println(printSubString(str, 2, 6));
    }
}
