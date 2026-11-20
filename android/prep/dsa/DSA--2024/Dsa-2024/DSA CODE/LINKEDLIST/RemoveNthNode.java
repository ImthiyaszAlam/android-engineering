public class RemoveNthNode {

    public static class Node {
        int data;
        Node next;

        public Node(int d) {
            this.data = d;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public static void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public static void printLinkedList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void reverseLL() {
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void removeNthNode(int nth) {
        int size = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        if (nth == size) {
            head = head.next;
        }

        int index = 1;
        int indexToFind = size - nth;
        Node prev = head;
        while (index < indexToFind) {
            prev = prev.next;
            index++;
        }
        prev.next = prev.next.next;
    }

    public static void main(String[] args) {
        addFirst(1);
        addFirst(2);
        addFirst(3);
        addFirst(4);
        addFirst(5);

        printLinkedList();

        reverseLL();
        printLinkedList();
        removeNthNode(1);
        printLinkedList();

    }
}
