public class Compare {
    public static void main(String[] args) {
        String s1 = "anna";
        String s2 = "anna";
        String  s3 = new String("anna");

        if (s1 == s2) {
            System.out.println("s1 & s2 are equal");
        }else{
            System.out.println("s1 & s2 are not equal");
        }

        
        if (s1.equals(s3)) {
            System.out.println("s1 & s3 are equal");
        }else{
            System.out.println("s1 & s3 are not equal");
        }
    }
}
