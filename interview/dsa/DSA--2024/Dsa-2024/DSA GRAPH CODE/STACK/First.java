
public class First {


    // Node Class
    public static class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
            next = null;
        }
    }

    // Stack class
    static  class Stack {
        static Node head;
        public static boolean isStackEmpty(){
            return head == null;
        }
        // PUSH Function
        public static void push(int data){
            Node newNode = new Node(data);
            if (isStackEmpty()) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode; 
        }
        // Pop function
        public static int pop(){
            if (isStackEmpty()) {
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }
        // peek function
        public static int peek(){
            if (isStackEmpty()) {
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        while (!stack.isStackEmpty()) {
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}