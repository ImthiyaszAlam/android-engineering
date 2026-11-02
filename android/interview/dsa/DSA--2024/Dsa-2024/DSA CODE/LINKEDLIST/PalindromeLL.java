public class PalindromeLL {

    public static class Node {
        int data;
        Node next;

        public Node(int d){
            this.data = d;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;


    public static void addFirst(int data){
        Node newNode = new Node(data);
        if (head == null) {
            tail = head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    
    }

    public static void printLL(){
        Node temp = head;
        while (temp!=null) {
            System.out.print(temp.data+"-->");
            temp = temp.next;
        }
        System.out.println();
    }


    public static Node midNode(Node head){
        Node slow = head;
        Node fast = head;

        while (slow !=null && fast !=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static boolean checkPalindrome(){
        if (head == null || head.next == null) {
            return true;
        }

       // Step 1 - find mid
        Node midNode = midNode(head);
        // Step 2 - Reverse second half
        Node prev = null;
        Node curr = midNode;
        Node next;

        while (curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;
        Node left = head;

        while (right !=null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static void main(String[] args) {
        addFirst(6);
        addFirst(5);
        addFirst(4);
        addFirst(4);
        addFirst(5);
        addFirst(6);

        printLL();
      System.out.println(checkPalindrome());
    }
}
