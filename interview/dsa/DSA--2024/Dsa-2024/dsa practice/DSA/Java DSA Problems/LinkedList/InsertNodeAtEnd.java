public class InsertNodeAtEnd {
    private Node head;
    public InsertNodeAtEnd(){
        this.head = null;
    }
    public Node insertNodeAtEnd(int data){
        if (head == null) {
            head = new Node(data);
        }else{
            Node node = head;
            while (node.addressToNextNode!=null) {
                node = node.addressToNextNode;
            }
            node.addressToNextNode = new Node(data);
        }
        return head;
    }

    public void printLinkedlist(){

        Node temp = head;
        while (temp!=null) {
            System.out.print(temp.data+ " ");
            temp = temp.addressToNextNode;
        }
    }

    public static void main(String[] args) {
        InsertNodeAtEnd insertNodeAtEnd = new InsertNodeAtEnd();
        insertNodeAtEnd.insertNodeAtEnd(3);
        insertNodeAtEnd.insertNodeAtEnd(4);
        insertNodeAtEnd.insertNodeAtEnd(5);
        insertNodeAtEnd.insertNodeAtEnd(6);
        insertNodeAtEnd.printLinkedlist();
    }
}
