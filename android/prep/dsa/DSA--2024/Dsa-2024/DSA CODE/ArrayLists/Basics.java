import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Basics
 */
public class Basics {

    public static void main(String[] args) {
        ArrayList<Integer>list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(6);
        list.add(5);

        System.out.println(list);
        int size = list.size();
        System.out.println( "size: "+ size);
        int element = list.get(1);
        System.out.println("at index 1: "+element);
        list.set(0, 1);
        System.out.println("updated list: "+list);
        System.out.println("list contains 2: " +list.contains(2));
        System.out.println("current list: "+list);
        Collections.sort(list);
        System.out.println("sorted list: "+list);
        System.out.print("reverse list ");
        Collections.sort(list,Collections.reverseOrder());
        System.out.println(list);

    }
}