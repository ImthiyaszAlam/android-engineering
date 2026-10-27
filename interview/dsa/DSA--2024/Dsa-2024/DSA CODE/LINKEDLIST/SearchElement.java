public class SearchElement {

    public class Node {
    
        int data;
        Node next;

        public Node(int d){
            this.data=d;
            this.next = null;
        }
    }
    

    public static Node hNode;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        Node firstNode = new Node(data);
        firstNode.next = hNode;
        hNode = firstNode;
    }

    public void printLL(){
        Node temp = hNode;
        while (temp!=null) {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println();
    }


    public int searchElement(int element){
        Node temp = hNode;
        int index = 0;
        while (temp !=null) {
            if (element == temp.data) {
                System.out.println("element fount: "+temp.data+" at index: "+index);
            }
            index++;
            temp = temp.next;
        }
        
        System.out.println("Doesn't  exists "+element+" in this Ll");
        return -1;
    }

    public static void main(String[] args) {
        SearchElement searchElement = new SearchElement();
        int element  = 20;
        searchElement.addFirst(10);
        searchElement.addFirst(11);
        searchElement.addFirst(12);
        searchElement.addFirst(13);
        searchElement.addFirst(14);
        searchElement.addFirst(15);

        searchElement.searchElement(element);
        
    }
}
