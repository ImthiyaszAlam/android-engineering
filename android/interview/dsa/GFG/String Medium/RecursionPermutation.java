import java.util.List;

public class RecursionPermutation {

    public static void recurPerm(int index, StringBuilder str, List<String> ans) {
        if (index == str.length()) {
            ans.add(str.toString());
            return;
        }

        for (int i = index; i < str.length(); i++) {
            swap(str,index,i);
        }
    }

    public static void swap(StringBuilder str,int i,int j){
        char temp = str.charAt(i);
        str.setCharAt(i, str.charAt(j));
        str.setCharAt(j, temp);
    }

    public static void main(String[] args) {

    }
}
