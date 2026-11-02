public class DuplicateString {

    public static void duplicateString(String s[]){
        for(int i=0;i<s.length;i++){
            for(int j=i+1;j<s.length;j++){
                if (s[i].equals(s[j])) {
                    System.out.print(s[i]+ " ");
                }
            }
        }
    }
    public static void main(String[] args) {
        String s[]  ={"anna","alam","anna","alam"};
        duplicateString(s);
    }
}
