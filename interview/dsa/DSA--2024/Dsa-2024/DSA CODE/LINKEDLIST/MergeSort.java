import java.util.LinkedList;

public class MergeSort {

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

    public static Node getMid() {
        Node slow = head;
        Node fast = head.next;

        while (fast!=null  || fast.next!=null) {
            slow = slow.next;
            fast = fast.next;
        }
       return slow;
    }

    public static Node mergeSort(Node head){
        if (head == null || head.next == null) {
            return head;
        }
        Node midNode = getMid();
        Node rightHead = midNode.next;
        midNode.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(rightHead);
        return merge(left,right);
    }

    public static Node merge(Node head, Node rightHead){
       Node mergerLinkedList = new Node(-1);
       Node temp = mergerLinkedList;
       while (head !=null && rightHead !=null) {
        if (head.data <=rightHead.data) {
            temp.next=head;
            head = head.next;
            temp = temp.next;
        }else{
            temp.next = rightHead;
            rightHead = rightHead.next;
            temp = temp.next;
        }

       }
       while (head!=null) {
        temp.next = head;
        head = head.next;
        temp = temp.next;
    }
    while (rightHead!=null) {
        temp.next = rightHead;
        rightHead = rightHead.next;
        temp = temp.next;
    }
       return mergerLinkedList.next;
    }
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(1);
        list.addFirst(3);
        list.addFirst(2);
        list.addLast(5);
        list.addLast(4);

        System.out.println(list);
        head = mergeSort(head);
        System.out.println(list);
    }
}
