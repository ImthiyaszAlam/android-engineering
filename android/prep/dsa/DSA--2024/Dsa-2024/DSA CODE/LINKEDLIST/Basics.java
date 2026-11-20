public class Basics {

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

    public void addFirstNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        }
        newNode.next = head;
        newNode = head;
    }

    public void addLast(int data) {
        Node lastNode = new Node(data);
        if (head == null) {
            head = tail = lastNode;
        }
        tail.next = lastNode;
        head = lastNode;

    }

    public void printLinkedList() {
        if (head == null) {
            System.out.println("Linkedlist is empty");
        }


        Node temp = head;

        if (temp == null) {
            System.out.println("Linkedlist is empty");
            return;
        }

        while (temp != null) {
            System.out.print(temp.data + " ->");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Basics basics = new Basics();
        basics.printLinkedList();
        basics.addFirstNode(1);
        basics.printLinkedList();
        basics.addFirstNode(2);
        basics.printLinkedList();

        basics.addLast(11);
        basics.printLinkedList();
        basics.addLast(12);
        basics.printLinkedList();
    }
}
