import java.util.*;

public class JCFQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(3);
        q.add(2);
        q.add(5);
        q.add(6);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
        System.out.println("size: "+q.size());
        q.
    }
}
