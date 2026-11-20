class Merge{
    public static void main(String[] args) {
        

        String s1 = "abc";
        String s2 = "pqr";
        String mergedString = "";

        int i,j,l1,l2;
        l1 = s1.length();
        l2 = s2.length();

        for(i=0; i<l1 || i<l2; i++){
            if (i<l1) {
                mergedString+=s1.charAt(i);
            }

            if (i<l2) {
                mergedString+=s2.charAt(i);
            }

        }

        System.out.println(mergedString);
        
    }
}