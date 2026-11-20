public class DLL {

    public static class Node {
        int data;
        Node next;
        Node prev;

        Node(int d) {
            this.data = d;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public static void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        size++;
    }

    public static void printLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void removeFirst() {
        if (head == null) {
            System.out.println("Empty linkedList");
        }
        head = head.next;
        head.prev = null;
        size--;

    }

    public static void main(String[] args) {
        addFirst(1);
        addFirst(2);
        addFirst(3);
        addFirst(4);
        addFirst(5);
        addFirst(6);

        printLL();
        removeFirst();
        printLL();
    }
}
