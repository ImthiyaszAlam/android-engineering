public class AddLast {
    
    public static class Node {
        int data;
        Node next;
        public boolean isEmpty;
    
        public Node(int data){
            this.data =data;
            this.next = null;
        }
        }
    
        public static Node head;
        public static Node tail;
    

        public static void main(String[] args) {
        AddFirst a = new AddFirst();
        a.addFirst(1);
        
        a.addFirst(2);
        AddLast al = new AddLast();
        al.addLast(6);
        }

}
