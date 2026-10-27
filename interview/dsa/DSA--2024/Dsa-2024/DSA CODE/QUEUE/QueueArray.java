
public class QueueArray {

    public class Queue {
        static int arr[];
        static int size;
        static int rear;

          public Queue(int n){
           arr = new int[n];
           size = n;
           rear = -1;
          }

          public static boolean isEmpty(){
            return rear ==-1; 
          }

          public static void add(int data){
            if (rear == size-1) {
                System.out.println("Queue is full");
                return;
            }
            rear+=1;
            arr[rear] = data;
          }

          public static int remove(){
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            int front = arr[0];
            for(int i=0;i<rear;i++){
                arr[i] = arr[i+1];
            }
            rear = rear-1;
            return front;
          }

          public static int peek(){
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            return arr[0];
          }
    }


    public static void main(String[] args) {
        QueueArray q = new QueueArray();
        Queue queue = new Queue(5);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        while (!queue.isEmpty()) {
            queue.peek();
            queue.remove();
        }
    }





}