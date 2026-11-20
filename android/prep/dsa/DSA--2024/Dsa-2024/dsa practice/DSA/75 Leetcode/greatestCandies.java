public class greatestCandies {


    public boolean[] kidsWithCandies(int candies[] , int extraCandies){
        int totalChild = candies.length;
        int maxCandie = 0;
        for(int i=0; i<totalChild; i++){
            maxCandie = Math.max(maxCandie, i);
        }

        boolean canHaveMaxCandie[] = new boolean[totalChild];
        for(int i =0; i<totalChild; i++){
            canHaveMaxCandie[i] = candies[i] + extraCandies >=maxCandie;
        }
        return canHaveMaxCandie;

    }
public static void main(String[] args) {
    int candies[] = {1,2,3,4,5,6,7,8};
    int extraCandies = 3;

    greatestCandies greatestCandie = new greatestCandies();
    boolean[] result = greatestCandie.kidsWithCandies(candies, extraCandies);
    System.out.println("can kids greater candie ?:");

    for(boolean canHaveMaxCandie : result){
System.out.println(canHaveMaxCandie);
    }
}

}
