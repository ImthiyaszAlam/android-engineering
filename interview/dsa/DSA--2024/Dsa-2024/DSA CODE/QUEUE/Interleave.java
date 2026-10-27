import java.util.LinkedList;
import java.util.Queue;

public class Interleave {

    public static void interLeave(Queue<Integer> originalQueue) {
        Queue<Integer> firstHalf = new LinkedList<>();
        int size = originalQueue.size();
        for(int i=0;i<size/2;i++){
            firstHalf.add(originalQueue.remove());
        }

        while (!firstHalf.isEmpty()) {
            originalQueue.add(firstHalf.remove());
            originalQueue.add(originalQueue.remove());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);       // 16 27 38 49 510
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        interLeave(q);
   
        while (!q.isEmpty()) {
            System.out.print(q.remove()+" ");
        }

    }
}
