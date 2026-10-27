public class NumberPairs {

    public void numberPairsCount(int x[] , int y[] ,int m , int n){
        m = x.length;
        n = y.length;
        int count = 0;

        int zeros = 0;
        int one  = 0;
        int two = 0;
        int three  = 0;
        int four  = 0;


        //traversing through y and finding count of each element
        for(int i=0; i<n; i++){
            if (y[i] == 0 )zeros++;
            if (y[i] == 1 )one++;
            if (y[i] == 2 )two++;
            if (y[i] == 3 )three++;
            if (y[i] == 4 )four++;
            
        }


        //traversing through x and 
        for(int j=0; j<m;j++){
            if (x[j] == 0) {
                continue;
            }
        }


    }
    public static void main(String[] args) {
        
    }
}
