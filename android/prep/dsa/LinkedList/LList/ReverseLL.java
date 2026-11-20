public class ReverseLL {

    static Node hNode;

    public  Node reverseLL(Node node) {
        Node prev = null;
        Node curr = hNode;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
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

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        ReverseLL nReverseLL = new ReverseLL();
        nReverseLL.insertAtEnd(1);
        nReverseLL.insertAtEnd(2);
        nReverseLL.insertAtEnd(3);
        nReverseLL.insertAtEnd(4);

     printList(hNode);
     hNode = nReverseLL.reverseLL(hNode);
        printList(hNode);
    }
}

class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
