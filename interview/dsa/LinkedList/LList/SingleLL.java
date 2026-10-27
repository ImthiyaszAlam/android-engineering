public class SingleLL {

    Node hNode;

//Creating node and shifting head to newly created node 
    void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = hNode;
        hNode = newNode;
    }

    void insertAtEnd(int data) {
        Node node = new Node(data);
        if (hNode == null) {
            node = hNode;
            return;
        }

        Node temp = hNode;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = hNode;
    }

    void printLList() {
        Node temp = hNode;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        SingleLL list = new SingleLL();
        list.insertAtBeginning(1);
        list.insertAtBeginning(2);

        list.insertAtEnd(4);
        list.insertAtEnd(5);

        list.printLList();
    }
}

class Node {
    int data;
    Node next;

    Node(int d) {
        this.data = d;
        this.next = null;
    }
}
