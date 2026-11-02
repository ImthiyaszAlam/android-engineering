
public class AddFirst {

    public static class Node {
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public static void addFirst(int data){
        Node newNode = new Node(data);
        if (head == null) {
        head = tail = newNode;
        return;
        }
        newNode.next = head;
        head = newNode;
    }

    public static void addLast(int data){
        Node lastNode = new Node(data);
        if (head == null) {
            head = tail = lastNode;
            return;
        }
        tail.next = lastNode;
        tail = lastNode;
    }



    public void printLinkedList(){
        Node temp = head;
        while (temp!=null) {
            System.out.print(temp.data+"-->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    
    public static void main(String[] args) {
        AddFirst add = new AddFirst();
        add.addFirst(1);
        add.printLinkedList();
        add.addFirst(2);
        add.printLinkedList();
        add.addFirst(3);
        add.printLinkedList();
        add.addLast(5);
        add.printLinkedList();
        add.addLast(6);
        add.printLinkedList();
        add.addLast(7);
        add.printLinkedList();
    }  
}