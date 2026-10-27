import java.util.HashSet;
import java.util.Set;

public class FirstRepeating {
    public static void main(String[] args) {
        int a[] = {1,2,1,3,45,6};
        int firstRepeatingChar = -1;
        Set<Integer>set = new HashSet<>();
        for(int i=a.length-1;i>0;i--){
            if (set.contains(a[i])) {
                firstRepeatingChar = a[i];
            }else{
                set.add(a[i]);
            }
        }
        System.out.println(set);
        System.out.println("firstRepeatingChar is "+firstRepeatingChar);
    }
}
