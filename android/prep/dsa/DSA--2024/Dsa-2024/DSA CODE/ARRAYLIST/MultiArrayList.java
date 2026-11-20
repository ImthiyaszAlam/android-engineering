import java.util.ArrayList;
import java.util.Collections;

public class MultiArrayList {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer>list1 = new ArrayList<>();
        list1.add(5);
        list1.add(10);
        list1.add(15);


        ArrayList<Integer>list2 = new ArrayList<>();
        list2.add(10);
        list2.add(15);
        list2.add(20);

        mainList.add(list1);
        mainList.add(list2);

        for(int i=0;i<mainList.size();i++){
            ArrayList<Integer>currentList = mainList.get(i);
        }

    }
}
