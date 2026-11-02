import java.util.ArrayList;
import java.util.Collections;

public class Basics {
public static void main(String[] args) {
    ArrayList<Integer>list1 = new ArrayList<>();
    list1.add(10);
    list1.add(3);
    list1.add(2);
    list1.add(5);
    list1.add(4);

    System.out.println(list1);
    Collections.sort(list1);
    System.out.println("sorted");
    System.out.println(list1);

    Collections.sort(list1,Collections.reverseOrder());
    System.out.println(list1);
}
    
}