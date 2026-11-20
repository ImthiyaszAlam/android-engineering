public class RemoveLL {

    public class Node {
        int data;
        Node next;

        public Node(int d) {
            this.data = d;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        size++;
        Node firstNode = new Node(data);
        firstNode.next = head;
        head = firstNode;
    }

    public void printLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println();
    }

    public int removeFirst(){
        if (size == 0) {
            System.out.println("empty LL");
            return Integer.MAX_VALUE;
        }
        size--;
        int value  = head.data;
        head = head.next;
        return value;
    }
    public static void main(String[] args) {
        RemoveLL removeLL = new RemoveLL();
        removeLL.addFirst(10);
        removeLL.addFirst(15);
        removeLL.addFirst(20);
        removeLL.printLL();
        removeLL.removeFirst();
        System.out.println("after removal of first node");
        removeLL.printLL();
        System.out.println("size of LL is : "+size);
    }
}
