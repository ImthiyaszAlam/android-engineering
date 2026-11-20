public class IntegerConversion {


    public static int value(char ch){
        
        if (ch=='I') {
            return 1;
        }
        
        if (ch=='V') {
            return 5;
        }
        
        if (ch=='X') {
            return 10;
        }
        
        if (ch=='L') {
            return 50;
        }
        
        if (ch=='C') {
            return 100;
        }
        
        if (ch=='D') {
            return 1000;
        }
        return -1;


    }
    
    public static int romalToDeceimal(String str){
        int result = 0;

        for(int i=0;i<str.length();i++){
            int s1 = value(str.charAt(i));

            if (i+1<str.length()) {
                int s2 = value(str.charAt(i+1));
                

                if (s1>=s2) {
                    result+=s1;
                }else{
                     result+=(s2-s1);
                     i++;
                }
            }else{
                result+=s1;
            }
        }

        return result;
    }



    public static void main(String[] args) {
        String str = "IV";
        System.out.println(romalToDeceimal(str));
    }
}
