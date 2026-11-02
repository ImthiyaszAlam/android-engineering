public class MiddleLLFastSlow {
    static Node hNode;

    public static void findMiddleNode() {
        Node slow = hNode;
        Node fast = hNode;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Middle Element: " + slow.data);
    }

    public static void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (hNode == null) {
            hNode = newNode;
            return;
        }

        Node temp = hNode;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public static void printLinkedList() {
        Node temp = hNode;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {

        MiddleLLFastSlow ll = new MiddleLLFastSlow();
        ll.insertAtEnd(0);
        ll.insertAtEnd(2);
        ll.insertAtEnd(3);
        ll.printLinkedList();
        ll.findMiddleNode();
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
