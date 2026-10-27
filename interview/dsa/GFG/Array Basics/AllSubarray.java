import java.util.ArrayList;

public class AllSubarray {

    public static void subArrays(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i; j < arr.size(); j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(+arr.get(k) + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
       
        subArrays(arrayList);
    }
}
