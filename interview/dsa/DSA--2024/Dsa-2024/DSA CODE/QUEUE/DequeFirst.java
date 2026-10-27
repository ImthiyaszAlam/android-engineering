import java.util.*;

public class DequeFirst {
    public static void main(String[] args) {

        Deque<Integer>deque = new LinkedList<>();
        deque.addFirst(1);
       
        deque.addFirst(2);
        deque.addLast(3);
        deque.addLast(4);
        deque.addLast(10);
        System.out.println(deque);

        deque.removeFirst();
        System.out.println("first element : "+deque.removeFirst());
        System.out.println("last element : "+deque.removeLast());
    }
}
