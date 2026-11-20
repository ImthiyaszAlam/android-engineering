import java.util.ArrayList;

public class ArrayListStack {

    static class Stack {
        static ArrayList<Integer> arrayStack = new ArrayList<>();

        public static boolean isStackEmpty() {
            return arrayStack.size() == 0;
        }

        // push
        public static void push(int data) {
            arrayStack.add(data);
        }

        // pop
        public static int pop() {
            if (isStackEmpty()) {
                return -1;
            }
            int top = arrayStack.get(arrayStack.size() - 1);
            arrayStack.remove(arrayStack.size() - 1);
            return top;
        }

        // peek
        public static int peek() {
            if (isStackEmpty()) {
                return -1;
            }
            return arrayStack.get(arrayStack.size() - 1);
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        
        s.push(4);
        s.push(4);
        s.push(4);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(4);
        s.push(4);
        s.push(4);

        while (!s.isStackEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
