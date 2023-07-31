import java.util.Stack;

class SortedStack {

    private Stack<Integer> stack = null;
    private Stack<Integer> temp = null;

    public SortedStack() {
        stack = new Stack<Integer>();
        temp = new Stack<Integer>();
    }

    public void push(int val) {
        sortMin(val);
    }

    private void sortMin(int val) {
        while (!stack.isEmpty() && stack.peek() < val) {
            int value = stack.pop();
            temp.push(value);
        }
        stack.push(val);
        while (!temp.isEmpty()) {
            int value = temp.pop();
            stack.push(value);
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int peek() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

/**
 * Your SortedStack object will be instantiated and called as such: SortedStack
 * obj = new SortedStack(); obj.push(val); obj.pop(); int param_3 = obj.peek();
 * boolean param_4 = obj.isEmpty();
 */