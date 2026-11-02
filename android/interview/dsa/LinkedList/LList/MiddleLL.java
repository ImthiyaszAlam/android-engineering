
public class MiddleLL {

    static Node hNode;

    public static void findMiddle() {
        int count = 0;
        Node temp = hNode;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        int mid = count / 2;
        temp = hNode;
        for (int i = 0; i < mid; i++) {
            temp = temp.next;
        }
        System.out.println("Middle Element: " + temp.data);

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

    public static void printList() {
        Node temp = hNode;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        MiddleLL middleLL = new MiddleLL();
        middleLL.insertAtEnd(1);
        middleLL.insertAtEnd(1);
        middleLL.insertAtEnd(1);
        middleLL.insertAtEnd(1);
        middleLL.printList();
        middleLL.findMiddle();
        
    }
}