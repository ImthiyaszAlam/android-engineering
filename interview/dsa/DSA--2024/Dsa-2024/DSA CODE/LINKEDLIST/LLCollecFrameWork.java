import java.util.*;
public class LLCollecFrameWork {
    public static void main(String[] args) {
      LinkedList<Integer>list = new LinkedList<>();
      list.addLast(1);
      list.addLast(2);
      list.addLast(3);
      list.addLast(4);
      list.addFirst(0);

      System.out.println(list);

      list.removeFirst();
      System.out.println(list);
      list.removeLast();
      System.out.println(list);
    }
}
