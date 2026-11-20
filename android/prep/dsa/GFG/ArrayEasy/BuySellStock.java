public class BuySellStock {

    pu static maxProfitRec(int price[],int start ,int end){
        int result = 0;
        for(int i=start;i<end;i++){
            for(int j=i+1;j<=end;j++){
                if(price[j]>price[i])

                    int current = price[j]-price[i]+
                    maxProfitRec(price,start,i-1)+
                    maxProfitRec(maxProfitRec,j+1,end);
                    result = Math.max(result,current);

            }
        }
        return result;

    }

    static int maxProfit(int [] prices){
        return maxProfitRec(price,0,prices.length-1);
    }
    public static void main(String[] args) {
        
    }
}
