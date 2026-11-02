public class CycleStart {

    static Node hNode;

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

    public static Node detectCycleStart() {
        Node slow = hNode;
        Node fast = hNode;

        while (fast != null && fast.next != null) {
            if (slow == fast) {
                slow = hNode;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
    }

    public static void createCycle(int pos) {
        if (pos == -1) {
            return;
        }

        Node temNode = hNode;
        Node cycleNode = null;
        int count = 0;

        while (temNode.next != null) {
            if (count == pos) {
                cycleNode = temNode;
            }
            temNode = temNode.next;
            count++;
        }
        temNode.next = cycleNode;
    }

    public static void main(String[] args) {
        CycleStart cs = new CycleStart();
        cs.insertAtEnd(1);
        cs.insertAtEnd(2);
        cs.insertAtEnd(3);
        cs.insertAtEnd(4);
        cs.insertAtEnd(5);

        cs.createCycle(2);

        Node cycleStart = cs.detectCycleStart();
        if (cycleStart != null) {
            System.out.println("Cycle starts at node: " + cycleStart.data);
        } else {
            System.out.println("No cycle in the Linked List.");
        }
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
