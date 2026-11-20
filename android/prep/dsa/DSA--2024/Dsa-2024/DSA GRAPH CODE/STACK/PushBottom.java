import java.util.Stack;

public class PushBottom {

    public static void pushBottom(int data, Stack<Integer> stack) {
        if (stack.isEmpty()) {
            stack.push(data);
        }
        int top = stack.pop();
        pushBottom(data, stack);
        stack.push(top);

    }

    public static void main(String[] args) {
        Stack s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        pushBottom(4, s);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
